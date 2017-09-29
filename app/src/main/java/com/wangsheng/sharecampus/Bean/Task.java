package com.wangsheng.sharecampus.bean;

/**
 * Created by windows8 on 2017/9/28.
 */

public class Task {
    String createrIconUrl;
    String createrName;
    String createTime;
    String taskTitle;
    String taskContent;
    String taskPlace;
    /**
     * 1--findPerson
     * 2--help
     * 3--other
     */
    int taskType;
    double taskPrice;
    String taskTime;

    public String getCreaterIconUrl() {
        return createrIconUrl;
    }

    public void setCreaterIconUrl(String createrIconUrl) {
        this.createrIconUrl = createrIconUrl;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public String getTaskPlace() {
        return taskPlace;
    }

    public void setTaskPlace(String taskPlace) {
        this.taskPlace = taskPlace;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public double getTaskPrice() {
        return taskPrice;
    }

    public void setTaskPrice(double taskPrice) {
        this.taskPrice = taskPrice;
    }

    public String getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(String taskTime) {
        this.taskTime = taskTime;
    }



}
