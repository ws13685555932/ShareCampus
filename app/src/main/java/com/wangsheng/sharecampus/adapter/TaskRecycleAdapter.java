package com.wangsheng.sharecampus.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wangsheng.sharecampus.activity.TaskActivity;
import com.wangsheng.sharecampus.bean.Task;
import com.wangsheng.sharecampus.R;

import java.util.List;

/**
 * Created by windows8 on 2017/9/28.
 */

public class TaskRecycleAdapter extends RecyclerView.Adapter<TaskRecycleAdapter.MyViewHolder>{
    private Context mContext;
    private List<Task> mData;
    //普通布局的type
    static final int TYPE_ITEM = 0;
    //脚布局

    public TaskRecycleAdapter(Context mContext, List<Task> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() + 1 : 0;
    }


    //自定义ViewHolder，用于加载图片
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.task_title);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        if (viewType == TYPE_ITEM) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recy_task, parent,
                false);
        MyViewHolder holder = new MyViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, TaskActivity.class);
                mContext.startActivity(intent);
            }
        });
//        //给布局设置点击和长点击监听
//        view.setOnClickListener(this);
//        view.setOnLongClickListener(this);

        return holder;
//        }
//        else if (viewType == TYPE_FOOTER) {
//            //脚布局
//            View view = View.inflate(mContext, R.layout.item_recy_foot, null);
//            FootViewHolder footViewHolder = new FootViewHolder(view);
//            return footViewHolder;
//        }
//        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        if (holder instanceof MyViewHolder) {
//            ((MyViewHolder) holder).title.setText(mData.get(position).getTaskTitle());
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
