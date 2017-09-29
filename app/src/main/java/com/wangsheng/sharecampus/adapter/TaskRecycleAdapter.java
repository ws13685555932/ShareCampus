package com.wangsheng.sharecampus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wangsheng.sharecampus.bean.Task;
import com.wangsheng.sharecampus.R;

import java.util.List;

/**
 * Created by windows8 on 2017/9/28.
 */

public class TaskRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener, View.OnLongClickListener {
    private Context mContext;
    private List<Task> mData;
    public TaskRecycleAdapter(Context mContext,List<Task> mData){
        this.mContext = mContext;
        this.mData = mData;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recy_task, parent,
                false);
        MyViewHolder holder = new MyViewHolder(view);

        //给布局设置点击和长点击监听
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);

        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }
    //自定义ViewHolder，用于加载图片
    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        public MyViewHolder(View view)
        {
            super(view);
        }
    }

}
