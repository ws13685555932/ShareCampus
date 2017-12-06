package com.wangsheng.sharecampus.bean;

/**
 * Created by windows8 on 2017/12/2.
 */

public class CommentBean {

    int taskId;
    int fromUid;
    int oUid;
    String content;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getoUid() {

        return oUid;
    }

    public void setoUid(int oUid) {
        this.oUid = oUid;
    }

    public int getFromUid() {

        return fromUid;
    }

    public void setFromUid(int fromUid) {
        this.fromUid = fromUid;
    }
}
