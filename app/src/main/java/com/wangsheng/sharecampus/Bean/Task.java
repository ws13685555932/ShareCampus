package com.wangsheng.sharecampus.Bean;

/**
 * Created by windows8 on 2017/9/28.
 */

public class Task {
    String Creatername;
    String Creatingtime;
    String TaskTitle;
    String TaskContent;
    String TaskPlace;
    TaskType Type;
    public String getCreatername() {
        return Creatername;
    }

    public void setCreatername(String creatername) {
        Creatername = creatername;
    }

    public String getTaskContent() {
        return TaskContent;
    }

    public TaskType getType() {
        return Type;
    }

    public void setType(TaskType type) {
        Type = type;
    }

    public String getTaskPlace() {
        return TaskPlace;
    }

    public void setTaskPlace(String taskPlace) {
        TaskPlace = taskPlace;
    }

    public void setTaskContent(String taskContent) {
        TaskContent = taskContent;
    }

    public String getTaskTitle() {
        return TaskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        TaskTitle = taskTitle;
    }

    public String getCreatingtime() {

        return Creatingtime;
    }

    public void setCreatingtime(String creatingtime) {
        Creatingtime = creatingtime;
    }
}
