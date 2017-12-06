package com.wangsheng.sharecampus.bean;

/**
 * Created by windows8 on 2017/12/2.
 */

public class OrderBean {
    int taskId;
    int receiverId;
    double price;
    int orderId;
    int orderStatus;
    int publisherId;

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public int getOrderStatus() {

        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {

        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getReceiverId() {

        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public int getTaskId() {

        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
