package com.example.mryang.myapplication0212.di.contrain;

import com.example.mryang.myapplication0212.data.bean.BannerBean;

public interface BannerContrain {

    public interface IBannerView{

        void setBannerData(BannerBean bannerBean);
    }

    public interface IBannerPresenter<IBannerView>{
        void attahView(IBannerView iBannerView);

        void detachView(IBannerView iBannerView);

        void goToRequestBannerData();
    }
    public interface IBannerModel{
        void containXBannerData(OnCallBack onCallBack);

        public interface OnCallBack{
            void setBannerData(BannerBean bannerBean);
        }
    }

}
