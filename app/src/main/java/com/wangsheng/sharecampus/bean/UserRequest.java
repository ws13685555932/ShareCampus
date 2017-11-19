package com.wangsheng.sharecampus.bean;

/**
 * Created by Administrator on 2017/5/23.
 */

public class UserRequest {
    String userName;
    String userPass;

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

    @Override
    public String toString() {
        return "UserRequest{" +
                "userName=" + userName +
                ", userPass=" + userPass +
                '}';
    }
}
