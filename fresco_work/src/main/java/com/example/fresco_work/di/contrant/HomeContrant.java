package com.example.fresco_work.di.contrant;



import com.example.fresco_work.data.bean.HomeBean;

import java.util.List;

public interface HomeContrant {

    public interface IHomeView{
        void setHomeData(List<HomeBean.ResultsBean.AndroidBean> androidBeans);
    }

    public interface IHomePresenter<IHomeView>{

        void attahView(IHomeView iHomeView);

        void detachView(IHomeView iHomeView);

        void goToRequestHomeData();
    }

    public interface IHomeModel{
        void containHomeModel(OnCallBack onCallBack);

        public interface OnCallBack{
            void getData(List<HomeBean.ResultsBean.AndroidBean> androidBeans);
        }

    }

}
