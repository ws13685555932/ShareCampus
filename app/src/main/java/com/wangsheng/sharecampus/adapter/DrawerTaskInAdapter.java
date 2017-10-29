package com.wangsheng.sharecampus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ruffian.library.RTextView;
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

public class DrawerTaskInAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context mContext;
    List<HashMap<String,String>> mData;
    public DrawerTaskInAdapter(List<HashMap<String,String>> mData,  Context mContext){
        this.mData = mData;
        this.mContext = mContext;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recy_intask, parent,
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
        ((viewHolder)holder).resttime.setText(data.get("resttime"));
        ((viewHolder)holder).type.setText(data.get("type"));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    class viewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.intask_text_content)
        TextView content;
        @BindView(R.id.intask_text_price)
        IconTextView price;
        @BindView(R.id.intask_text_showtimes)
        TextView showtimes;
        @BindView(R.id.intask_text_state)
        TextView state;
        @BindView(R.id.intask_text_title)
        TextView title;
        @BindView(R.id.intask_text_time)
        TextView time;
        @BindView(R.id.intask_text_resttime)
        TextView resttime;
        @BindView(R.id.intask_text_type)
        RTextView type;
        public viewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
