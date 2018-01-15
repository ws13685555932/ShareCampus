package com.wangsheng.sharecampus.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wangsheng.sharecampus.ApiServiceBean.TaskServiceResponse.TaskgetTaskResponse;
import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.activity.TaskActivity;
import com.wangsheng.sharecampus.view.IconTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by windows8 on 2017/10/29.
 */

public class DrawerTaskOutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context mContext;
    List<TaskgetTaskResponse> mData;
    int TYPE = 1;
    public DrawerTaskOutAdapter(List<TaskgetTaskResponse> mData, int TYPE, Context mContext){
        this.mData = mData;
        this.TYPE = TYPE;
        this.mContext = mContext;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recy_outtask, parent,
                false);
        viewHolder holder = new viewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final TaskgetTaskResponse data = mData.get(position);
        ((viewHolder)holder).title.setText(data.getTitle());
        ((viewHolder)holder).time.setText(data.getStarttime());
        ((viewHolder)holder).content.setText(data.getDescription());
        ((viewHolder)holder).showtimes.setText((int)Math.random()*50+"");
        ((viewHolder)holder).state.setText(data.getEndtime());
        ((viewHolder)holder).price.setText(data.getPrice()+"金");
        if(TYPE ==3 || TYPE == 4) {
            ((viewHolder) holder).state.setText("已完成");
        }
        ((viewHolder)holder).task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, TaskActivity.class);
                TaskActivity.task = data;
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    class viewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.task)
        LinearLayout task;
        @BindView(R.id.outtask_text_content)
        TextView content;
        @BindView(R.id.outtask_rl_complete)
        RelativeLayout rlcomplete;
        @BindView(R.id.outtask_rl_ing)
        RelativeLayout rling;
        @BindView(R.id.outtask_rl_wait)
        RelativeLayout rlwait;
        @BindView(R.id.outtask_rl_waitevaluate)
        RelativeLayout rlwe;
        @BindView(R.id.outtask_text_price)
        IconTextView price;
        @BindView(R.id.outtask_text_showtimes)
        TextView showtimes;
        @BindView(R.id.outtask_text_state)
        TextView state;
        @BindView(R.id.outtask_text_title)
        TextView title;
        @BindView(R.id.outtask_text_time)
        TextView time;
        public viewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            switch (TYPE){
                case 1:
                    rlwait.setVisibility(View.VISIBLE);
                    rlcomplete.setVisibility(View.GONE);
                    rling.setVisibility(View.GONE);
                    rlwe.setVisibility(View.GONE);
                    break;
                case 2:
                    rlwait.setVisibility(View.GONE);
                    rlcomplete.setVisibility(View.GONE);
                    rling.setVisibility(View.VISIBLE);
                    rlwe.setVisibility(View.GONE);
                    break;
                case 3:
                    rlwait.setVisibility(View.GONE);
                    rlcomplete.setVisibility(View.GONE);
                    rling.setVisibility(View.GONE);
                    rlwe.setVisibility(View.VISIBLE);
                    break;
                default:
                    rlwait.setVisibility(View.GONE);
                    rlcomplete.setVisibility(View.VISIBLE);
                    rling.setVisibility(View.GONE);
                    rlwe.setVisibility(View.GONE);
                    break;
            }
        }
    }
}
