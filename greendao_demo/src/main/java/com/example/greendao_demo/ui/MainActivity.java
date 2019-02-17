package com.example.greendao_demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.greendao_demo.R;
import com.example.greendao_demo.data.bean.UserBean;
import com.example.greendao_demo.gen.UserBeanDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    @BindView(R.id.btn_update)
    Button btnUpdate;
    @BindView(R.id.btn_query)
    Button btnQuery;
    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_add, R.id.btn_delete, R.id.btn_update, R.id.btn_query})
    public void onViewClicked(View view) {
        UserBeanDao userBeanDao = App.getDaoSession().getUserBeanDao();
        switch (view.getId()) {
            case R.id.btn_add:
                //增加数据
                for (int i = 0; i < 10; i++) {
                    UserBean userBean = new UserBean();
                    userBean.setName("上官"+i);
                    userBean.setAge("16岁");
                    userBeanDao.insertOrReplace(userBean);
                }
                break;
            case R.id.btn_delete:
                userBeanDao.deleteAll();
            /*删除全部
            * userBeanDao.deleteAll();
            * */
            //删除第几条数据
            /*userBeanDao.deleteByKey((long) 2);*/
                break;
            case R.id.btn_update:
                UserBean counter = new UserBean();
                counter.setId((long) 4);
                counter.setAge("90");
                counter.setName("陈旭123");

                userBeanDao.updateInTx(counter);
                break;
            case R.id.btn_query:
                List<UserBean> userBeans = userBeanDao.loadAll();
                StringBuilder stringBuilder = new StringBuilder();
                //循环
                for (int i = 0; i < userBeans.size(); i++) {
                    UserBean userBean = userBeans.get(i);
                    String userInfo = userBean.toString();
                    stringBuilder.append(userInfo+"***");
                }
                //查询到的所有数据设置给TextView进行显示
                String showInfo = stringBuilder.toString();
                tvContent.setText(showInfo);
                break;
        }
    }
}
