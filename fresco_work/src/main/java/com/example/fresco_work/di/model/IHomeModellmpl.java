package com.example.fresco_work.di.model;


import com.example.fresco_work.data.apils.Aplis;
import com.example.fresco_work.data.bean.HomeBean;
import com.example.fresco_work.di.contrant.HomeContrant;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.List;

public class IHomeModellmpl implements HomeContrant.IHomeModel {
    @Override
    public void containHomeModel(final OnCallBack onCallBack) {
        OkGo.<String>get(Aplis.HOME_URL).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String responseData = response.body().toString();
                Gson gson = new Gson();
                HomeBean homeBean = gson.fromJson(responseData, HomeBean.class);
                List<HomeBean.ResultsBean.AndroidBean> androidBeans = homeBean.getResults().getAndroid();
                onCallBack.getData(androidBeans);
            }
        });
    }
}
