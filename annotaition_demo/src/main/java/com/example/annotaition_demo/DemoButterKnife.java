package com.example.annotaition_demo;

import android.app.Activity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DemoButterKnife {
    public static void bind(Activity activity) {
        //1.setContentView(R.layout.activity_main);
        //将视图绘制移入其中
        bindView(activity);
    }
    /**
     * 绑定根视图
     */
    private static void bindView(Activity activity) {
        //获取类对象
        Class<? extends Activity> demoClazz = activity.getClass();
        try {
            //通过类对象获取setContentView(R.layout.activity_main);
            Method method = demoClazz.getMethod("setContentView", int.class);
            //通过类型获取注解
            DemoLayout annotation = demoClazz.getAnnotation(DemoLayout.class);
            int layout = annotation.value();
            //如果能获取到方法再向下执行
            if (null != method) {
                method.invoke(activity,layout);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
