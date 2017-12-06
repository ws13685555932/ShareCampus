package com.wangsheng.sharecampus.bean;

/**
 * Created by windows8 on 2017/12/2.
 */

public class FollowBean {
    int followerId;
    int followedId;
    int followId;

    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    public int getFollowedId() {

        return followedId;
    }

    public void setFollowedId(int followedId) {
        this.followedId = followedId;
    }

    public int getFollowerId() {

        return followerId;
    }

    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }
}
