package com.example.mryang.myapplication0212.di.presenter;

import com.example.mryang.myapplication0212.data.bean.BannerBean;
import com.example.mryang.myapplication0212.di.contrain.BannerContrain;
import com.example.mryang.myapplication0212.di.model.BannerModellmpl;

import java.lang.ref.SoftReference;

public class IPresenterlmpl implements BannerContrain.IBannerPresenter<BannerContrain.IBannerView> {
    BannerContrain.IBannerView iBannerView;
    private SoftReference<BannerContrain.IBannerView> reference;
    private BannerModellmpl modellmpl;

    @Override
    public void attahView(BannerContrain.IBannerView iBannerView) {
        this.iBannerView = iBannerView;
        reference = new SoftReference<>(iBannerView);
        modellmpl = new BannerModellmpl();
    }

    @Override
    public void detachView(BannerContrain.IBannerView iBannerView) {
        reference.clear();
    }

    @Override
    public void goToRequestBannerData() {
        modellmpl.containXBannerData(new BannerContrain.IBannerModel.OnCallBack() {
            @Override
            public void setBannerData(BannerBean bannerBean) {
                iBannerView.setBannerData(bannerBean);
            }
        });
    }
}
