package com.wangsheng.sharecampus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wangsheng.sharecampus.bean.Business;
import com.wangsheng.sharecampus.R;

import java.util.List;

/**
 * Created by windows8 on 2017/10/1.
 */

public class BusinessAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>implements View.OnClickListener,View.OnLongClickListener{
    private Context mContext;
    private List<Business> list;
    public BusinessAdapter( Context mContext,  List<Business> list){
        this.mContext = mContext;
        this.list = list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recy_wallet, parent,
                false);
        BusinessHolder businessHolder = new BusinessHolder(view);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return businessHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BusinessHolder)holder).name.setText(list.get(position).getBusinessSend()+"+"+list.get(position).getBusinessType());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }
    class BusinessHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        public BusinessHolder(View view)
        {
            super(view);
            name = view.findViewById(R.id.iv_name);
        }
    }
}
