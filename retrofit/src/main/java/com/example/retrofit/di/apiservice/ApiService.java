package com.example.retrofit.di.apiservice;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

//1.定义接口（封装URL地址和数据请求）
//子接口存放的内容
public interface ApiService {
    @GET("small/commodity/v1/commodityList")
    Call<ResponseBody> getResponseGoodsData();
}
