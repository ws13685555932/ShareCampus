package com.wangsheng.sharecampus.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wangsheng.sharecampus.config.HttpConfig;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/5/6.
 */

public class HttpManager {
    private final Gson mGsonDateFormat;

    private HttpManager(){
        mGsonDateFormat = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();
    }

    private static class SingletonHolder{
        private static final HttpManager INSTANCE = new HttpManager();
    }

    public static HttpManager getInstance(){
        return SingletonHolder.INSTANCE;
    }

    //创建接口服务
    public <S> S createService(Class<S> serviceClass){
        String baseUrl = HttpConfig.BASE_URL;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(mGsonDateFormat))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }










}
