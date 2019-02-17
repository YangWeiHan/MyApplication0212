package com.example.firstweekwork.data.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.firstweekwork.R;
import com.example.firstweekwork.data.bean.GoodsBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class PzshAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ONE=1;
    private static final int TYPE_TWO=2;
    private Context context;
    private List<GoodsBean.ResultBean.PzshBean.CommodityListBeanX> pzshList;

    public PzshAdapter(Context context, List<GoodsBean.ResultBean.PzshBean.CommodityListBeanX> pzshList) {
        this.context = context;
        this.pzshList = pzshList;
    }

    public void setPzshList(List<GoodsBean.ResultBean.PzshBean.CommodityListBeanX> pzshList) {
        if (pzshList != null){
            this.pzshList = pzshList;
        }
        notifyDataSetChanged();
    }
    public void addPzshList(List<GoodsBean.ResultBean.PzshBean.CommodityListBeanX> pzshList) {
        if (pzshList != null){
          this.pzshList.addAll(pzshList);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == TYPE_ONE){
            View view = LayoutInflater.from(context).inflate(R.layout.type_one_item,viewGroup,false);
            return new ViewHolderOne(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.type_two_item,viewGroup,false);
            return new ViewHolderTwo(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        switch (itemViewType){
            case TYPE_ONE:
                ViewHolderOne viewHolderOne = (ViewHolderOne) viewHolder;
                viewHolderOne.text_name.setText(pzshList.get(i).getPrice()+"");
                SimpleDraweeView image_icon = viewHolderOne.image_icon;
                Uri parse = Uri.parse(pzshList.get(i).getMasterPic());
                AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
                        .setUri(parse)
                        .setAutoPlayAnimations(true)
                        .build();
                image_icon.setController(build);
                break;
            case TYPE_TWO:
                ViewHolderTwo viewHolderTwo = (ViewHolderTwo) viewHolder;
                viewHolderTwo.text_name.setText(pzshList.get(i).getPrice()+"");
                SimpleDraweeView image_icon_two = viewHolderTwo.image_icon;
                Uri parse_two = Uri.parse(pzshList.get(i).getMasterPic());
                AbstractDraweeController build_two = Fresco.newDraweeControllerBuilder()
                        .setUri(parse_two)
                        .setAutoPlayAnimations(true)
                        .build();
                image_icon_two.setController(build_two);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return pzshList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position% 2 == 1){
            return TYPE_ONE;
        }else {
            return TYPE_TWO;
        }
    }

    class ViewHolderOne extends RecyclerView.ViewHolder{
        private TextView text_name;
        private SimpleDraweeView image_icon;

        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);
            text_name = itemView.findViewById(R.id.type_item_tv_view);
            image_icon = itemView.findViewById(R.id.type_item_sd_view);
        }
    }
    class ViewHolderTwo extends RecyclerView.ViewHolder{
        private TextView text_name;
        private SimpleDraweeView image_icon;

        public ViewHolderTwo(@NonNull View itemView) {
            super(itemView);
            text_name = itemView.findViewById(R.id.type_item_tv_view);
            image_icon = itemView.findViewById(R.id.type_item_sd_view);
        }
    }
}
