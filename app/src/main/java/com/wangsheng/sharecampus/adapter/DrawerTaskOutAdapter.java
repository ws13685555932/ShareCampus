package com.wangsheng.sharecampus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.view.IconTextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by windows8 on 2017/10/29.
 */

public class DrawerTaskOutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context mContext;
    List<HashMap<String,String>> mData;
    int TYPE = 1;
    public DrawerTaskOutAdapter(List<HashMap<String,String>> mData, int TYPE, Context mContext){
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
        Map<String,String> data = mData.get(position);
        ((viewHolder)holder).title.setText(data.get("title"));
        ((viewHolder)holder).time.setText(data.get("time"));
        ((viewHolder)holder).content.setText(data.get("content"));
        ((viewHolder)holder).showtimes.setText(data.get("showtimes"));
        ((viewHolder)holder).state.setText(data.get("state"));
        ((viewHolder)holder).price.setText(data.get("price"));
        if(TYPE ==3 || TYPE == 4){
            ((viewHolder)holder).state.setText("已完成");
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    class viewHolder extends RecyclerView.ViewHolder{
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
