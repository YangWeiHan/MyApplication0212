package com.example.mryang.myapplication0212.di.presenter;

import com.example.mryang.myapplication0212.data.bean.GoodsBean;
import com.example.mryang.myapplication0212.di.contrain.GoodsContrain;
import com.example.mryang.myapplication0212.di.model.GoodsModellmpl;

import java.lang.ref.SoftReference;

public class IGoodsPresenter implements GoodsContrain.IGoodsPresenter<GoodsContrain.IGoodsView> {
    GoodsContrain.IGoodsView IGoodsView;
    private SoftReference<GoodsContrain.IGoodsView> reference;
    private GoodsModellmpl modellmpl;

    @Override
    public void attahView(GoodsContrain.IGoodsView IGoodsView) {
        this.IGoodsView = IGoodsView;
        reference = new SoftReference<>(IGoodsView);
        modellmpl = new GoodsModellmpl();
    }

    @Override
    public void detachView(GoodsContrain.IGoodsView IGoodsView) {
        reference.clear();
    }

    @Override
    public void goToRequestGoodsData() {
        modellmpl.containXGoodsData(new GoodsContrain.IGoodsModel.GoodCallBack() {
            @Override
            public void setGoodsData(GoodsBean goodsBean) {
                IGoodsView.setGoodsData(goodsBean);
            }
        });
    }
}
