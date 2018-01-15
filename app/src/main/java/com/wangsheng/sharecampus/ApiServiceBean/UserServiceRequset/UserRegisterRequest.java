package com.wangsheng.sharecampus.ApiServiceBean.UserServiceRequset;

/**
 * Created by windows8 on 2017/12/2.
 */

public class UserRegisterRequest {
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
}
