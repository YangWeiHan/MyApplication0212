package com.example.retrofit.data.adapter;

import android.net.Uri;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.retrofit.R;
import com.example.retrofit.data.bean.GoodsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class PzssAdapter extends BaseQuickAdapter<GoodsBean.ResultBean.PzshBean.CommodityListBeanX,BaseViewHolder> {
    public PzssAdapter(int layoutResId, @Nullable List<GoodsBean.ResultBean.PzshBean.CommodityListBeanX> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsBean.ResultBean.PzshBean.CommodityListBeanX item) {
        helper.setText(R.id.right_goods_price,item.getCommodityName());
        String masterPic = item.getMasterPic();
        String[] split = masterPic.split("\\|");
        Uri parse = Uri.parse(split[0]);
        SimpleDraweeView image_goods = helper.getView(R.id.right_goods_commodityName);
        image_goods.setImageURI(parse);
    }
}
