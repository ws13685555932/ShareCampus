package com.wangsheng.sharecampus.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.activity.TaskActivity;
import com.wangsheng.sharecampus.bean.SkillBean;
import com.wangsheng.sharecampus.bean.Task;

import java.util.List;

/**
 * Created by wangsheng
 * on 2017/10/14.
 */

public class SkillRecyclerAdapter extends RecyclerView.Adapter<SkillRecyclerAdapter.MyViewHolder> {
    private Context mContext;
    private List<SkillBean> mData;

    public SkillRecyclerAdapter(Context mContext, List<SkillBean> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public MyViewHolder(View view) {
            super(view);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recy_skill, parent,
                false);
        SkillRecyclerAdapter.MyViewHolder holder = new SkillRecyclerAdapter.MyViewHolder(view);

//        //给布局设置点击和长点击监听
//        view.setOnClickListener(this);
//        view.setOnLongClickListener(this);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
