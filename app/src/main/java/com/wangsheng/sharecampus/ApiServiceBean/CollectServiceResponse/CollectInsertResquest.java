package com.wangsheng.sharecampus.ApiServiceBean.CollectServiceResponse;

/**
 * Created by windows8 on 2017/12/12.
 */

public class CollectInsertResquest {
    int collectorId;
    int taskId;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getCollectorId() {

        return collectorId;
    }

    public void setCollectorId(int collectorId) {
        this.collectorId = collectorId;
    }
}
