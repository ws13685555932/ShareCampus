package com.wangsheng.sharecampus;

import android.content.Context;

import com.mob.MobApplication;

/**
 * Created by wangsheng
 * on 2017/10/2.
 */

public class MyApplication extends MobApplication {
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
