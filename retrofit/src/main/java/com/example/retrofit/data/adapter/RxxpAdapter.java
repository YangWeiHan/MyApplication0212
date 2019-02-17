package com.example.retrofit.data.adapter;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.retrofit.R;
import com.example.retrofit.data.bean.GoodsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class RxxpAdapter extends BaseQuickAdapter<GoodsBean.ResultBean.RxxpBean.CommodityListBean,BaseViewHolder> {
    public RxxpAdapter(int layoutResId, @Nullable List<GoodsBean.ResultBean.RxxpBean.CommodityListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsBean.ResultBean.RxxpBean.CommodityListBean item) {
        helper.setText(R.id.right_goods_price,item.getCommodityName());
        String masterPic = item.getMasterPic();
        String[] split = masterPic.split("\\|");
        Uri parse = Uri.parse(split[0]);
        SimpleDraweeView image_goods = helper.getView(R.id.right_goods_commodityName);
        image_goods.setImageURI(parse);

    }
}
