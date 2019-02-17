package com.example.fresco_0214;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fresco_0214.data.adapter.HomoData_Adapter;
import com.example.fresco_0214.data.bean.HomeDataBean;
import com.example.fresco_0214.di.contrant.HomeContrant;
import com.example.fresco_0214.di.presenter.IHomePresenterlmpl;

import java.util.List;


public class HomeFragment extends Fragment implements HomeContrant.IHomeView {
    private RecyclerView home_recyclerView;
    private IHomePresenterlmpl presenterlmpl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        home_recyclerView = view.findViewById(R.id.home_recyclerView);
        presenterlmpl = new IHomePresenterlmpl();
        presenterlmpl.attahView(this);
        presenterlmpl.goToRequestHomeData();
        return view;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        presenterlmpl.detachView(this);
    }

    @Override
    public void setHomeData(List<HomeDataBean.ResultsBean> results) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        home_recyclerView.setLayoutManager(gridLayoutManager);
        HomoData_Adapter homoData_adapter = new HomoData_Adapter(R.layout.home_item, results);
        home_recyclerView.setAdapter(homoData_adapter);
    }
}
