package com.wangsheng.sharecampus.ApiServiceBean.UserServiceRequset;

/**
 * Created by Administrator on 2017/5/23.
 */

public class UserLoginRequest {
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
