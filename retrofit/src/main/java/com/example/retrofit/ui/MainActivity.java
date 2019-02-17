package com.example.retrofit.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.retrofit.R;
import com.example.retrofit.data.adapter.MLSSAdapter;
import com.example.retrofit.data.adapter.PzssAdapter;
import com.example.retrofit.data.adapter.RxxpAdapter;
import com.example.retrofit.data.bean.GoodsBean;
import com.example.retrofit.di.contrain.IGoodsContrain;
import com.example.retrofit.di.presenter.IGoodsPresenterlmpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IGoodsContrain.IGoodsView {


    @BindView(R.id.rv_rxxp)
    RecyclerView rvRxxp;
    @BindView(R.id.rv_pzss)
    RecyclerView rvPzss;
    @BindView(R.id.rv_mlss)
    RecyclerView rvMlss;
    @BindView(R.id.rxxp)
    Button rxxp;
    @BindView(R.id.pzss)
    Button pzss;
    @BindView(R.id.mlss)
    Button mlss;
    private IGoodsPresenterlmpl presenterlmpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenterlmpl = new IGoodsPresenterlmpl();
        presenterlmpl.attahView(this);
        presenterlmpl.goToRequestGoodsData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterlmpl.detachView(this);
    }

    @Override
    public void setGoodsData(GoodsBean goodsBean) {
        List<GoodsBean.ResultBean.RxxpBean> rxxp_data = goodsBean.getResult().getRxxp();
        List<GoodsBean.ResultBean.PzshBean> pzsh_data = goodsBean.getResult().getPzsh();
        List<GoodsBean.ResultBean.MlssBean> mlss_data = goodsBean.getResult().getMlss();
        /*for (int i = 0; i < result.getMlss().size(); i++) {
            String name = result.getMlss().get(i).getName();
            Toast.makeText(this, "这是数据" + name, Toast.LENGTH_LONG).show();

        }*/
        if (rxxp_data != null) {
            if (rxxp_data.size() <= 0) {
                return;
            } else {
                for (int i = 0; i < rxxp_data.size(); i++) {
                    //数据源
                    List<GoodsBean.ResultBean.RxxpBean.CommodityListBean> commodityList = rxxp_data.get(i).getCommodityList();
                    //布局
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                    rvRxxp.setLayoutManager(linearLayoutManager);
                    RxxpAdapter rxxpAdapter = new RxxpAdapter(R.layout.right_item, commodityList);
                    rvRxxp.setAdapter(rxxpAdapter);

                }
            }
        }
        if (mlss_data != null) {
            if (mlss_data.size() <= 0) {
                return;
            } else {
                for (int i = 0; i < mlss_data.size(); i++) {
                    //数据源
                    List<GoodsBean.ResultBean.MlssBean.CommodityListBeanXX> commodityList = mlss_data.get(i).getCommodityList();
                    //布局
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                    rvMlss.setLayoutManager(linearLayoutManager);
                    MLSSAdapter mlssAdapter = new MLSSAdapter(R.layout.right_item, commodityList);
                    rvMlss.setAdapter(mlssAdapter);

                }
            }
        }
        if (pzsh_data != null) {
            if (pzsh_data.size() <= 0) {
                return;
            } else {
                for (int i = 0; i < pzsh_data.size(); i++) {
                    //数据源
                    List<GoodsBean.ResultBean.PzshBean.CommodityListBeanX> commodityList = pzsh_data.get(i).getCommodityList();
                    //布局
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                    rvPzss.setLayoutManager(linearLayoutManager);
                    PzssAdapter pzssAdapter = new PzssAdapter(R.layout.right_item, commodityList);
                    rvPzss.setAdapter(pzssAdapter);

                }
            }
        }

    }


    @OnClick({R.id.rxxp, R.id.pzss, R.id.mlss})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rxxp:
                rvRxxp.setVisibility(View.VISIBLE);
                rvPzss.setVisibility(View.GONE);
                rvMlss.setVisibility(View.GONE);
                break;
            case R.id.pzss:
                rvPzss.setVisibility(View.VISIBLE);
                rvRxxp.setVisibility(View.GONE);
                rvMlss.setVisibility(View.GONE);
                break;
            case R.id.mlss:
                rvMlss.setVisibility(View.VISIBLE);
                rvRxxp.setVisibility(View.GONE);
                rvPzss.setVisibility(View.GONE);

                break;
        }
    }
}
