package com.example.retrofit.data.adapter;

import android.net.Uri;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.retrofit.R;
import com.example.retrofit.data.bean.GoodsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MLSSAdapter extends BaseQuickAdapter<GoodsBean.ResultBean.MlssBean.CommodityListBeanXX,BaseViewHolder> {

    public MLSSAdapter(int layoutResId, @Nullable List<GoodsBean.ResultBean.MlssBean.CommodityListBeanXX> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsBean.ResultBean.MlssBean.CommodityListBeanXX item) {
        helper.setText(R.id.right_goods_price,item.getCommodityName());
        String masterPic = item.getMasterPic();
        String[] split = masterPic.split("\\|");
        Uri parse = Uri.parse(split[0]);
        SimpleDraweeView image_goods = helper.getView(R.id.right_goods_commodityName);
        image_goods.setImageURI(parse);
    }
}
