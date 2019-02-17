package com.example.fresco_0214.di.contrant;

import com.example.fresco_0214.data.bean.HomeDataBean;

import java.util.List;

public interface HomeContrant {

    public interface IHomeView{
        void setHomeData(List<HomeDataBean.ResultsBean> results);
    }

    public interface IHomePresenter<IHomeView>{

        void attahView(IHomeView iHomeView);

        void detachView(IHomeView iHomeView);

        void goToRequestHomeData();
    }

    public interface IHomeModel{
        void containHomeModel(OnCallBack onCallBack);

        public interface OnCallBack{
            void getData(List<HomeDataBean.ResultsBean> results);
        }

    }

}
