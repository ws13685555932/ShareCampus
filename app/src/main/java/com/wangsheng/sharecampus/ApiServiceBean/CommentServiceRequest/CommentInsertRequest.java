package com.wangsheng.sharecampus.ApiServiceBean.CommentServiceRequest;

/**
 * Created by windows8 on 2017/12/12.
 */

public class CommentInsertRequest {
    int taskId;
    int fromUid;
    int toUid;
    String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getToUid() {

        return toUid;
    }

    public void setToUid(int toUid) {
        this.toUid = toUid;
    }

    public int getFromUid() {

        return fromUid;
    }

    public void setFromUid(int fromUid) {
        this.fromUid = fromUid;
    }

    public int getTaskId() {

        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
