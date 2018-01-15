package com.wangsheng.sharecampus.ApiServiceBean.PocketServiceRequest;

/**
 * Created by windows8 on 2017/12/12.
 */

public class PocketUpdateRequest {
    int userId;
    int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
