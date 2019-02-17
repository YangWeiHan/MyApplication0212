package com.example.fresco_work.data.adapter;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.fresco_work.R;
import com.example.fresco_work.data.bean.HomeBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class HomeAdapter extends BaseQuickAdapter<HomeBean.ResultsBean.AndroidBean,BaseViewHolder> {

    public HomeAdapter(int layoutResId, @Nullable List<HomeBean.ResultsBean.AndroidBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.ResultsBean.AndroidBean item) {

        /*Uri parse = Uri.parse(item.getImages().get(0));*/
        if (null != item.getImages()){
            String home_image = item.getImages().get(0);
            SimpleDraweeView image_icon = helper.getView(R.id.home_icon);
            DraweeController builder = Fresco.newDraweeControllerBuilder()
                    .setUri(home_image)
                    .setAutoPlayAnimations(true)
                    .build();
            image_icon.setController(builder);
        }

        helper.setText(R.id.home_time, item.getDesc());
    }
}
