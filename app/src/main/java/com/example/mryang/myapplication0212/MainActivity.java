package com.example.mryang.myapplication0212;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mryang.myapplication0212.data.bean.BannerBean;
import com.example.mryang.myapplication0212.data.bean.GoodsBean;
import com.example.mryang.myapplication0212.di.contrain.BannerContrain;
import com.example.mryang.myapplication0212.di.contrain.GoodsContrain;
import com.example.mryang.myapplication0212.di.presenter.IPresenterlmpl;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BannerContrain.IBannerView,GoodsContrain.IGoodsView {

    @BindView(R.id.item_menu_icon)
    SimpleDraweeView itemMenuIcon;
    @BindView(R.id.zhiqingju)
    TextView zhiqingju;
    @BindView(R.id.menu_tablayout)
    TabLayout menuTablayout;
    @BindView(R.id.menu_viewpager)
    ViewPager menuViewpager;
    @BindView(R.id.line1)
    LinearLayout line1;
    @BindView(R.id.home_xbanner)
    XBanner homeXbanner;
    @BindView(R.id.goods_recyclerview)
    RecyclerView goodsRecyclerview;
    private IPresenterlmpl presenterlmpl;
    private List<String> banner_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenterlmpl = new IPresenterlmpl();
        presenterlmpl.attahView(this);
        presenterlmpl.goToRequestBannerData();
        menuViewpager.setAdapter(new Tab_adapter(getSupportFragmentManager()));
        menuTablayout.setupWithViewPager(menuViewpager);
        //加载Fresco图片
        Uri uri = Uri.parse("D:\\MyApplication0212\\app\\src\\main\\res\\drawable\\item_menu.png");
        itemMenuIcon.setImageURI(uri);
    }

    @Override
    public void setBannerData(BannerBean bannerBean) {
        banner_list = new ArrayList<>();
        for (int i = 0; i < bannerBean.getResult().size(); i++) {
            banner_list.add(bannerBean.getResult().get(i).getImageUrl());
        }
        homeXbanner.setData(banner_list, null);
        homeXbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(MainActivity.this).load(banner_list.get(position)).into((ImageView) view);
            }
        });
    }

    @Override
    public void setGoodsData(GoodsBean goodsBean) {
        List<GoodsBean.DataBean> goodsBeanData = goodsBean.getData();
    }
}
