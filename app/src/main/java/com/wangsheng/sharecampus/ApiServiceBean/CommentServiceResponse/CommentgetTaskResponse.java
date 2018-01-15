package com.wangsheng.sharecampus.ApiServiceBean.CommentServiceResponse;

import java.sql.Timestamp;

/**
 * Created by windows8 on 2017/12/12.
 */

public class CommentgetTaskResponse {
    int commentId;
    int taskId;
    int fromUid;
    int toUid;
    String content;
    Timestamp sendTime;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

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
