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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((MyViewHolder) holder).title.setText(mData.get(position).getTaskTitle());
        ((MyViewHolder) holder).name.setText(mData.get(position).getCreaterName());
        ((MyViewHolder) holder).price.setText(mData.get(position).getTaskPrice()+"");
        ((MyViewHolder) holder).content.setText(mData.get(position).getTaskContent());
        ((MyViewHolder) holder).time.setText(mData.get(position).getCreateTime());
        ((MyViewHolder) holder).task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaskActivity.task = mData.get(position);
                Intent intent = new Intent(mContext, TaskActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
//        if (holder instanceof MyViewHolder) {
//            ((MyViewHolder) holder).title.setText(mData.get(position).getTaskTitle());
//            ((MyViewHolder) holder).name.setText(mData.get(position).getCreaterName());
//            ((MyViewHolder) holder).price.setText(mData.get(position).getTaskPrice()+"金");
//            ((MyViewHolder) holder).content.setText(mData.get(position).getTaskContent());
//            ((MyViewHolder) holder).time.setText(mData.get(position).getCreateTime());
//            ((MyViewHolder) holder).task.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    TaskActivity.task = mData.get(position);
//                    Intent intent = new Intent(mContext, TaskActivity.class);
//                    mContext.startActivity(intent);
//                }
//            });
//        } else if (holder instanceof FootViewHolder) {
//            FootViewHolder footViewHolder = (FootViewHolder) holder;
//            if (position == 0) {//如果第一个就是脚布局,,那就让他隐藏
//                footViewHolder.mProgressBar.setVisibility(View.GONE);
//                footViewHolder.tv_line1.setVisibility(View.GONE);
//                footViewHolder.tv_line2.setVisibility(View.GONE);
//                footViewHolder.tv_state.setText("");
//            }
//            switch (footer_state) {//根据状态来让脚布局发生改变
//                case PULL_LOAD_MORE://上拉加载
//                    footViewHolder.mProgressBar.setVisibility(View.GONE);
//                    footViewHolder.tv_state.setText("上拉加载更多");
//                    break;
//                case LOADING_MORE:
//                    footViewHolder.mProgressBar.setVisibility(View.VISIBLE);
//                    footViewHolder.tv_line1.setVisibility(View.GONE);
//                    footViewHolder.tv_line2.setVisibility(View.GONE);
//                    footViewHolder.tv_state.setText("正在加载...");
//                    break;
//                case NO_MORE:
//                    footViewHolder.mProgressBar.setVisibility(View.GONE);
//                    footViewHolder.tv_line1.setVisibility(View.VISIBLE);
//                    footViewHolder.tv_line2.setVisibility(View.VISIBLE);
//                    footViewHolder.tv_state.setText("我是有底线的");
//                    footViewHolder.tv_state.setTextColor(Color.parseColor("#ff00ff"));
//                    break;
//            }
//        }
//    }


//    @Override
//    public int getItemViewType(int position) {
//        //如果position加1正好等于所有item的总和,说明是最后一个item,将它设置为脚布局
//        if (position + 1 == getItemCount()) {
//            return TYPE_FOOTER;
//        } else {
//            return TYPE_ITEM;
//        }
//    }
//
//
//    /**
//     * 脚布局的ViewHolder
//     */
//    public static class FootViewHolder extends RecyclerView.ViewHolder {
//        private ProgressBar mProgressBar;
//        private TextView tv_state;
//        private TextView tv_line1;
//        private TextView tv_line2;
//
//
//        public FootViewHolder(View itemView) {
//            super(itemView);
//            mProgressBar = (ProgressBar) itemView.findViewById(R.id.progressbar);
//            tv_state = (TextView) itemView.findViewById(R.id.foot_view_item_tv);
//            tv_line1 = (TextView) itemView.findViewById(R.id.tv_line1);
//            tv_line2 = (TextView) itemView.findViewById(R.id.tv_line2);
//
//        }
//    }
//
//    /**
//     * 改变脚布局的状态的方法,在activity根据请求数据的状态来改变这个状态
//     *
//     * @param state
//     */
//    public void changeState(int state) {
//        this.footer_state = state;
//        notifyDataSetChanged();
//    }


}
