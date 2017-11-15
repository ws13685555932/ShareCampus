package com.wangsheng.sharecampus.util;


import android.util.Log;

import com.wangsheng.sharecampus.bean.ResponseInfo;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/5/6.
 */

public abstract class HttpObserver<T> implements Observer<ResponseInfo<T>> {
    private static final String TAG = "HttpObserver";

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onNext(ResponseInfo<T> responseInfo) {
        if(responseInfo.getStatusCode().equals("200")){
            onSuccess(responseInfo.getData());
        }else{
            onFailed(responseInfo.getMessage());
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onError: " + e.getMessage());
        e.printStackTrace();

        String msg;
        if (e instanceof UnknownHostException) {
            msg = "没有网络";
        } else if (e instanceof SocketTimeoutException) {
            // 超时
            msg = "请求超时";
        }else{
            msg = e.getMessage();
        }
        onFailed(msg);

    }

    public abstract void onSuccess(T t);
    public abstract void onFailed(String message);

}
