package com.wangsheng.sharecampus.bean;

/**
 * Created by wangsheng
 * on 2017/9/29.
 */

public class ResponseInfo<T> {
    String message;
    T data;
    String statusCode;

    @Override
    public String toString() {
        return "ResponseInfo{" +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", code=" + statusCode +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}