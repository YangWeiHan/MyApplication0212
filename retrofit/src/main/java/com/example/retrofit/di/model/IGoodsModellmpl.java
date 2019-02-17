package com.example.retrofit.di.model;

import com.example.retrofit.data.aplis.Aplis;
import com.example.retrofit.data.bean.GoodsBean;
import com.example.retrofit.di.apiservice.ApiService;
import com.example.retrofit.di.contrain.IGoodsContrain;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IGoodsModellmpl implements IGoodsContrain.IGoodsModel {
    @Override
    public void containGoodsModel(final OnCallBack onCallBack) {
        //2.创建retrofit实例
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Aplis.GOODS_URL)
                .build();
        //3.通过Retrofit实例创建接口服务对象
        ApiService apiService = retrofit.create(ApiService.class);
        //4.接口服务对象调用接口中的方法，获取Call对象
        Call<ResponseBody> call = apiService.getResponseGoodsData();
        //5.Call对象执行请求（异步、同步请求）
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody responseBody = response.body();
                try {
                    String responseData = responseBody.string();
                    Gson gson = new Gson();
                    GoodsBean goodsBean = gson.fromJson(responseData, GoodsBean.class);
                    onCallBack.getData(goodsBean);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                String errorMessage = t.getMessage();
            }
        });
    }
}
