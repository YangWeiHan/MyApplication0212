package com.example.mryang.myapplication0212.di.model;

import com.example.mryang.myapplication0212.data.Apils;
import com.example.mryang.myapplication0212.data.bean.GoodsBean;
import com.example.mryang.myapplication0212.di.contrain.GoodsContrain;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class GoodsModellmpl implements GoodsContrain.IGoodsModel {
    @Override
    public void containXGoodsData(final GoodCallBack goodCallBack) {
        OkGo.<String>get(Apils.SHOPDATA_URL).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String responseData = response.body().toString();
                Gson gson = new Gson();
                GoodsBean goodsBean = gson.fromJson(responseData, GoodsBean.class);
                goodCallBack.setGoodsData(goodsBean);
            }
        });
    }
}
