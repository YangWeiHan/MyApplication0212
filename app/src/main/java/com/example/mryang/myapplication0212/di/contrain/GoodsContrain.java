package com.example.mryang.myapplication0212.di.contrain;

import com.example.mryang.myapplication0212.data.bean.BannerBean;
import com.example.mryang.myapplication0212.data.bean.GoodsBean;

public interface GoodsContrain {

    public interface IGoodsView{

        void setGoodsData(GoodsBean goodsBean);
    }

    public interface IGoodsPresenter<IGoodsView>{
        void attahView(IGoodsView IGoodsView);

        void detachView(IGoodsView IGoodsView);

        void goToRequestGoodsData();
    }
    public interface IGoodsModel{
        void containXGoodsData(GoodCallBack goodCallBack);

        public interface GoodCallBack{
            void setGoodsData(GoodsBean goodsBean);
        }
    }

}
