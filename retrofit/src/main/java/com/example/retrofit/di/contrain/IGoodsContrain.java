package com.example.retrofit.di.contrain;

import com.example.retrofit.data.bean.GoodsBean;

public interface IGoodsContrain {
    public interface IGoodsView{
        void setGoodsData(GoodsBean goodsBean);
    }

    public interface IGoodsPresenter<IGoodsView>{

        void attahView(IGoodsView iGoodsView);

        void detachView(IGoodsView iGoodsView);

        void goToRequestGoodsData();
    }

    public interface IGoodsModel{
        void containGoodsModel(OnCallBack onCallBack);

        public interface OnCallBack{
            void getData(GoodsBean goodsBean);
        }

    }
}
