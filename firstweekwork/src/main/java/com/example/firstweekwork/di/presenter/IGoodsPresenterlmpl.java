package com.example.firstweekwork.di.presenter;

import com.example.firstweekwork.data.bean.BannerBean;
import com.example.firstweekwork.data.bean.GoodsBean;
import com.example.firstweekwork.di.contrain.IGoodsContrain;
import com.example.firstweekwork.di.model.IGoodsModellmpl;

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
            public void getGoodsData(GoodsBean goodsBean) {
                iGoodsView.setGoodsData(goodsBean);
            }
        });
    }

    @Override
    public void goToRequestBannerData() {
      modellmpl.containGBannerModel(new IGoodsContrain.IGoodsModel.BannerCallBack() {
          @Override
          public void getBannerData(BannerBean bannerBean) {
              iGoodsView.setBannerData(bannerBean);
          }
      });
    }
}
