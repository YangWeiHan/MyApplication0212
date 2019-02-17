package com.example.retrofit.di.presenter;

import com.example.retrofit.data.bean.GoodsBean;
import com.example.retrofit.di.contrain.IGoodsContrain;
import com.example.retrofit.di.model.IGoodsModellmpl;

import java.lang.ref.SoftReference;

public class IGoodsPresenterlmpl implements IGoodsContrain.IGoodsPresenter<IGoodsContrain.IGoodsView> {
    IGoodsContrain.IGoodsView iGoodsView;
    private SoftReference<IGoodsContrain.IGoodsView> reference;
    private IGoodsModellmpl modellmpl;

    @Override
    public void attahView(IGoodsContrain.IGoodsView iGoodsView) {
        this.iGoodsView = iGoodsView;
        reference = new SoftReference<>(iGoodsView);
        modellmpl = new IGoodsModellmpl();


    }

    @Override
    public void detachView(IGoodsContrain.IGoodsView iGoodsView) {
        reference.clear();

    }

    @Override
    public void goToRequestGoodsData() {
        modellmpl.containGoodsModel(new IGoodsContrain.IGoodsModel.OnCallBack() {
            @Override
            public void getData(GoodsBean goodsBean) {
                iGoodsView.setGoodsData(goodsBean);
            }
        });
    }
}
