package com.wangsheng.sharecampus.ApiServiceBean.UserServiceResponse;

/**
 * Created by windows8 on 2017/12/2.
 */

public class UserChangepassResponse {
    String userName;
    String newPass;

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getUserName() {
    
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
