package com.wangsheng.sharecampus.bean;

/**
 * Created by wangsheng
 * on 2017/9/29.
 */

public class ResponseInfoList<T> {
    String message;
    T dataList;
    String statusCode;

    @Override
    public String toString() {
        return "ResponseInfo{" +
                ", message='" + message + '\'' +
                ", dataList=" + dataList +
                ", code=" + statusCode +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDataList() {
        return dataList;
    }

    public void setDataList(T dataList) {
        this.dataList = dataList;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}