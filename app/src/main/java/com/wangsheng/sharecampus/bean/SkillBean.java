package com.wangsheng.sharecampus.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangsheng
 * on 2017/10/14.
 */

public class SkillBean {
    private int cateId;
    private String skillTotal;
    private List<String> skillList = new ArrayList<>();

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getSkillTotal() {
        return skillTotal;
    }

    public void setSkillTotal(String skillTotal) {
        this.skillTotal = skillTotal;
    }

    public List<String> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<String> skillList) {
        this.skillList = skillList;
    }
}
