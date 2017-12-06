package com.wangsheng.sharecampus.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.activity.TaskActivity;
import com.wangsheng.sharecampus.bean.Task;
import com.wangsheng.sharecampus.fragment.task.getTaskBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by windows8 on 2017/9/28.
 */

public class TaskRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener, View.OnLongClickListener {
    private Context mContext;
    private List<getTaskBean> mData;
    public TaskRecycleAdapter(Context mContext,List<getTaskBean> mData){
        this.mContext = mContext;
        this.mData = mData;
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
    //自定义ViewHolder
    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.task_title)
        TextView title;
        @BindView(R.id.text_content)
        TextView content;
        @BindView(R.id.task_user_name)
        TextView name;
        @BindView(R.id.text_price)
        TextView price;
        @BindView(R.id.text_time)
        TextView time;
        @BindView(R.id.task)
        LinearLayout task;
        @BindView(R.id.civ_user_icon)
        CircleImageView usericon;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
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
    int[] image = {R.drawable.image_head1,R.drawable.image_head2,R.drawable.image_head3,R.drawable.image_head4,R.drawable.image_head5};
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((MyViewHolder) holder).title.setText(mData.get(position).getTitle());
        if(mData.get(position).getPublisherName() == null){
            ((MyViewHolder) holder).name.setText(mData.get(position).getPublisherId());
        }else ((MyViewHolder) holder).name.setText(mData.get(position).getPublisherName());
        ((MyViewHolder) holder).price.setText(mData.get(position).getPrice()+"");
        ((MyViewHolder) holder).content.setText(mData.get(position).getDescription());
        ((MyViewHolder) holder).time.setText(mData.get(position).getPuttime());
        ((MyViewHolder) holder).usericon.setImageResource(image[position%5]);
        ((MyViewHolder) holder).task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaskActivity.task = mData.get(position);
                Intent intent = new Intent(mContext, TaskActivity.class);
                mContext.startActivity(intent);
            }
        });
    }


}
