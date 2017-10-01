package com.wangsheng.sharecampus.adapter;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wangsheng.sharecampus.Bean.Person;
import com.wangsheng.sharecampus.Bean.Task;
import com.wangsheng.sharecampus.R;

import java.util.List;


/**
 * Created by windows8 on 2017/10/1.
 */

public class CollectionPageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>implements View.OnClickListener,View.OnLongClickListener {
    private Context mContext;
    private List<Object> mData;
    private int type = 0;
    static final int TYPE_PERSON = 0;
    static final int TYPE_TASK = 1;
    public CollectionPageAdapter(Context mContext,List<Object> mData,int type){
        this.mContext = mContext;
        this.mData = mData;
        this.type = type;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_TASK) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_recy_coll_task, parent,
                    false);
            TaskViewHolder taskViewHolder = new TaskViewHolder(view);
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
            return taskViewHolder;
        }else  if (viewType == TYPE_PERSON) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_recy_coll_person, parent,
                    false);
            PersonViewHolder personViewHolder = new PersonViewHolder(view);
            view.setOnClickListener(this);
            return personViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof PersonViewHolder) {
            ((PersonViewHolder)holder).name.setText(((Person)mData.get(position)).getPersonName());
        }else{
            ((TaskViewHolder) holder).title.setText(((Task)mData.get(position)).getTaskTitle());
        }
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new AlertDialog.Builder(mContext).setTitle("提示：").setMessage("确认删除该收藏吗？")
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                mData.remove(position);
                                notifyDataSetChanged();
                            }
                        }).setNegativeButton("否", null).show();
                return false;
            }
        });
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

    class PersonViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        public PersonViewHolder(View view)
        {
            super(view);
            name = view.findViewById(R.id.iv_name);
        }
    }
    class TaskViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        public TaskViewHolder(View view)
        {
            super(view);
            title = view.findViewById(R.id.task_title);
        }
    }
    @Override
    public int getItemViewType(int position) {
        //如果position加1正好等于所有item的总和,说明是最后一个item,将它设置为脚布局
        if (type == TYPE_PERSON) {
            return TYPE_PERSON;
        } else {
            return TYPE_TASK;
        }
    }
}
