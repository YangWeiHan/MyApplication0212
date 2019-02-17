package com.example.firstweekwork.di.model;

import com.example.firstweekwork.data.aplis.Aplis;
import com.example.firstweekwork.data.bean.BannerBean;
import com.example.firstweekwork.data.bean.GoodsBean;
import com.example.firstweekwork.di.apiservice.ApiService;
import com.example.firstweekwork.di.contrain.IGoodsContrain;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IGoodsModellmpl implements IGoodsContrain.IGoodsModel {
    @Override
    public void containGoodsModel(final OnCallBack onCallBack) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Aplis.GOODS_URL).build();
        ApiService apiService = retrofit.create(ApiService.class);
        final Call<ResponseBody> goodsCall = apiService.getResponseGoodsData();
        goodsCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody responseBody = response.body();
                try {
                    String responesGoodsData = responseBody.string();
                    Gson gson = new Gson();
                    GoodsBean goodsBean = gson.fromJson(responesGoodsData, GoodsBean.class);
                    onCallBack.getGoodsData(goodsBean);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

    @Override
    public void containGBannerModel(final BannerCallBack bannerCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Aplis.Banner_URL)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        Call<ResponseBody> bannerCall = apiService.getResponseBannerData();
        bannerCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody responseBody = response.body();
                try {
                    String responseBannerData = responseBody.string();
                    Gson gson = new Gson();
                    BannerBean bannerBean = gson.fromJson(responseBannerData, BannerBean.class);

                    bannerCallBack.getBannerData(bannerBean);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            }
        });

    }
}
