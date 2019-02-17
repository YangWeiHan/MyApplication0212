package com.example.fresco_work.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fresco_work.R;
import com.example.fresco_work.data.bean.HomeBean;
import com.example.fresco_work.di.contrant.HomeContrant;

import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeContrant.IHomeView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setHomeData(List<HomeBean.ResultsBean.AndroidBean> androidBeans) {

    }
}
