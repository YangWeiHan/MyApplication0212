package com.example.mryang.myapplication0212.di.model;

import com.bumptech.glide.Glide;
import com.example.mryang.myapplication0212.data.Apils;
import com.example.mryang.myapplication0212.data.bean.BannerBean;
import com.example.mryang.myapplication0212.di.contrain.BannerContrain;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class BannerModellmpl implements BannerContrain.IBannerModel {

    @Override
    public void containXBannerData(final OnCallBack onCallBack) {
        OkGo.<String>get(Apils.XBANNER_HOME).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String bannerData = response.body().toString();
                Gson gson = new Gson();
                BannerBean bannerBean = gson.fromJson(bannerData, BannerBean.class);
                onCallBack.setBannerData(bannerBean);
            }
        });
    }
}
