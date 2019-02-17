package com.example.fresco_0214;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.fresco_0214.data.adapter.MyPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.sw_viewpager)
    ViewPager swViewpager;
    @BindView(R.id.sw_tablayout)
    TabLayout swTablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        swViewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        swTablayout.setupWithViewPager(swViewpager);
    }
}
