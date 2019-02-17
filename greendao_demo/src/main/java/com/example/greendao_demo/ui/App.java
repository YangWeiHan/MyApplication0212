package com.example.greendao_demo.ui;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.greendao_demo.gen.DaoMaster;
import com.example.greendao_demo.gen.DaoSession;

public class App extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        //参数1：上下文
        //参数2：数据库名称
        //参数3：游标工厂类
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(this,"GreenDaoDemo",null);
        //获取DataBase对象  可读可写
        SQLiteDatabase database = openHelper.getWritableDatabase();
        //创建DaoMaster对象
        DaoMaster daoMaster = new DaoMaster(database);
        //创建DaoSession对象
        daoSession = daoMaster.newSession();
    }
    public static DaoSession getDaoSession(){
        return daoSession;
    }
}
