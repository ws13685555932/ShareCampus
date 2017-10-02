package com.wangsheng.sharecampus;

import android.app.Application;
import android.content.Context;

/**
 * Created by wangsheng
 * on 2017/10/2.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    //返回
    public static Context getContext(){
        return context;
    }
}
