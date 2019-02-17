package com.example.firstweekwork.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.firstweekwork.R;
import com.example.firstweekwork.data.adapter.PzshAdapter;
import com.example.firstweekwork.data.bean.BannerBean;
import com.example.firstweekwork.data.bean.GoodsBean;
import com.example.firstweekwork.di.contrain.IGoodsContrain;
import com.example.firstweekwork.di.presenter.IGoodsPresenterlmpl;
import com.gongwen.marqueen.SimpleMF;
import com.gongwen.marqueen.SimpleMarqueeView;
import com.recker.flybanner.FlyBanner;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShowActivity extends AppCompatActivity implements IGoodsContrain.IGoodsView {


    @BindView(R.id.QR_Code)
    ImageView QRCode;
    @BindView(R.id.sou_edit)
    EditText souEdit;
    @BindView(R.id.simpleMarqueeView)
    SimpleMarqueeView simpleMarqueeView;
    @BindView(R.id.fly_image)
    FlyBanner flyImage;
    @BindView(R.id.rv_goods)
    RecyclerView rvGoods;
    private IGoodsPresenterlmpl presenterlmpl;
    private List<String> image_list;
    int request_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);
        presenterlmpl = new IGoodsPresenterlmpl();
        presenterlmpl.attahView(this);
        presenterlmpl.goToRequestBannerData();
        presenterlmpl.goToRequestGoodsData();
        final List<String> datas = Arrays.asList("《赋得古原草送别》", "离离原上草，一岁一枯荣。", "野火烧不尽，春风吹又生。", "远芳侵古道，晴翠接荒城。", "又送王孙去，萋萋满别情。");
        //SimpleMarqueeView<T>，SimpleMF<T>：泛型T指定其填充的数据类型，比如String，Spanned等

        SimpleMF<String> marqueeFactory = new SimpleMF(this);
        marqueeFactory.setData(datas);
        simpleMarqueeView.setMarqueeFactory(marqueeFactory);
        simpleMarqueeView.startFlipping();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == request_code) {
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果" + result, Toast.LENGTH_SHORT).show();
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(this, "解析失败", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterlmpl.detachView(this);
    }

    @Override
    public void setGoodsData(GoodsBean goodsBean) {
        List<GoodsBean.ResultBean.PzshBean> pzsh = goodsBean.getResult().getPzsh();
        if (pzsh != null) {
            if (pzsh.size() <= 0) {
                return;
            } else {
                for (int i = 0; i < pzsh.size(); i++) {
                    //得到数据源
                    List<GoodsBean.ResultBean.PzshBean.CommodityListBeanX> commodityList = pzsh.get(i).getCommodityList();
                    //布局
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(ShowActivity.this, 2, LinearLayoutManager.VERTICAL, false);
                    rvGoods.setLayoutManager(gridLayoutManager);
                    PzshAdapter pzshAdapter = new PzshAdapter(ShowActivity.this, commodityList);
                    rvGoods.setAdapter(pzshAdapter);
                }
            }
        }
    }

    @Override
    public void setBannerData(BannerBean bannerBean) {
        List<BannerBean.ResultBean> resultBannerData = bannerBean.getResult();
        image_list = new ArrayList<>();
        for (int i = 0; i < resultBannerData.size(); i++) {
            String imageUrl = resultBannerData.get(i).getImageUrl();
            image_list.add(imageUrl);
        }
        flyImage.setImagesUrl(image_list);


    }

    @OnClick(R.id.QR_Code)
    public void onViewClicked() {
        Intent intent = new Intent(ShowActivity.this, CaptureActivity.class);
        startActivityForResult(intent, request_code);
    }
}
