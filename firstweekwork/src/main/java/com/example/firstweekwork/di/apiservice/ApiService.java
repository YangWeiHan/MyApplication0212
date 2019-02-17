package com.example.firstweekwork.di.apiservice;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("small/commodity/v1/bannerShow")
    Call<ResponseBody> getResponseBannerData();
    @GET("small/commodity/v1/commodityList")
    Call<ResponseBody> getResponseGoodsData();

}
