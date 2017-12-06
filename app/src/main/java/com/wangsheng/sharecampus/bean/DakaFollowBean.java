package com.wangsheng.sharecampus.bean;

/**
 * Created by windows8 on 2017/12/2.
 */

public class DakaFollowBean {
    int Data;
    int followerId;
    int followNum;

    public int getFollowNum() {
        return followNum;
    }

    public void setFollowNum(int followNum) {
        this.followNum = followNum;
    }

    public int getFollowerId() {
        return followerId;
    }

    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }

    public int getData() {

        return Data;
    }

    public void setData(int data) {
        Data = data;
    }
}
