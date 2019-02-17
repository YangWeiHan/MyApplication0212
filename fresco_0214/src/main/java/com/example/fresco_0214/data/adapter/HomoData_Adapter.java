package com.example.fresco_0214.data.adapter;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.fresco_0214.R;
import com.example.fresco_0214.data.bean.HomeDataBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class HomoData_Adapter extends BaseQuickAdapter<HomeDataBean.ResultsBean,BaseViewHolder> {



    public HomoData_Adapter(int layoutResId, @Nullable List<HomeDataBean.ResultsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeDataBean.ResultsBean item) {
        helper.setText(R.id.home_time,item.getDesc());
        /*ImageView home_icon = helper.getView(R.id.home_icon);*/
        String url_icon = item.getUrl();
        String[] imageDetails = url_icon.split("\\|");
        Uri parse = Uri.parse(imageDetails[0]);
        SimpleDraweeView img = helper.getView(R.id.home_icon);
        img.setImageURI(parse);

    }
}
