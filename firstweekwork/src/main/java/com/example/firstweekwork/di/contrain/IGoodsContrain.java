package com.example.firstweekwork.di.contrain;


import com.example.firstweekwork.data.bean.BannerBean;
import com.example.firstweekwork.data.bean.GoodsBean;

public interface IGoodsContrain {
    public interface IGoodsView{
        void setGoodsData(GoodsBean goodsBean);

        void setBannerData(BannerBean bannerBean);
    }

    public interface IGoodsPresenter<IGoodsView>{

        void attahView(IGoodsView iGoodsView);

        void detachView(IGoodsView iGoodsView);

        void goToRequestGoodsData();
        void goToRequestBannerData();
    }

    public interface IGoodsModel{
        void containGoodsModel(OnCallBack onCallBack);

        public interface OnCallBack{
            void getGoodsData(GoodsBean goodsBean);
        }

        void containGBannerModel(BannerCallBack bannerCallBack);

        public interface BannerCallBack{
            void getBannerData(BannerBean bannerBean);
        }

    }
}
