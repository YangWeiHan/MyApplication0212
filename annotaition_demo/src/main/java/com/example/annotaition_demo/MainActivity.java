package com.example.annotaition_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
//把布局文件写在注解中
@DemoLayout(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    TextView tv_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        DemoButterKnife.bind(this);
    }
}
