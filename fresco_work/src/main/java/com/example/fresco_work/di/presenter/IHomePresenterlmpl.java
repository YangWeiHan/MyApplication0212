package com.example.fresco_work.di.presenter;


import com.example.fresco_work.data.bean.HomeBean;
import com.example.fresco_work.di.contrant.HomeContrant;
import com.example.fresco_work.di.model.IHomeModellmpl;

import java.lang.ref.SoftReference;
import java.util.List;

public class IHomePresenterlmpl implements HomeContrant.IHomePresenter<HomeContrant.IHomeView> {
    HomeContrant.IHomeView iHomeView;
    private SoftReference<HomeContrant.IHomeView> reference;
    private IHomeModellmpl modellmpl;

    @Override
    public void attahView(HomeContrant.IHomeView iHomeView) {
        this.iHomeView = iHomeView;
        reference = new SoftReference<>(iHomeView);
        modellmpl = new IHomeModellmpl();
    }

    @Override
    public void detachView(HomeContrant.IHomeView iHomeView) {
        reference.clear();
    }

    @Override
    public void goToRequestHomeData() {
        modellmpl.containHomeModel(new HomeContrant.IHomeModel.OnCallBack() {
            @Override
            public void getData(List<HomeBean.ResultsBean.AndroidBean> androidBeans) {
                iHomeView.setHomeData(androidBeans);
            }
        });
    }
}
