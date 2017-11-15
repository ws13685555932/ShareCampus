package com.wangsheng.sharecampus.bean;

import static android.R.attr.name;

/**
 * Created by Administrator on 2017/5/23.
 */

public class UserRequest {
    String userName;
    String userPass;
    String token;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "userName=" + userName +
                ", userPass='" + userPass + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
