package com.example.fresco_0214.di.model;

import com.example.fresco_0214.HomeFragment;
import com.example.fresco_0214.data.aplis.Aplis;
import com.example.fresco_0214.data.bean.HomeDataBean;
import com.example.fresco_0214.di.contrant.HomeContrant;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.List;

public class IHomeModellmpl implements HomeContrant.IHomeModel {

    @Override
    public void containHomeModel(final OnCallBack onCallBack) {
        OkGo.<String>get(Aplis.HOMEDATA_URL).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String responseData = response.body().toString();
                Gson gson = new Gson();
                HomeDataBean homeDataBean = gson.fromJson(responseData, HomeDataBean.class);
                List<HomeDataBean.ResultsBean> results = homeDataBean.getResults();
                onCallBack.getData(results);
            }
        });
    }
}
