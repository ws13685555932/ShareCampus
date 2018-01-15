package com.wangsheng.sharecampus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.bean.Business;

import java.util.List;

/**
 * Created by windows8 on 2017/10/1.
 */

public class BusinessAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>implements View.OnClickListener,View.OnLongClickListener{
    private Context mContext;
    private List<Business> list;
    int[] image = {R.drawable.image_head1,R.drawable.image_head2,R.drawable.image_head3,R.drawable.image_head4,R.drawable.image_head5};
    String[] time = {"今天 9:20","昨天 20:36","昨天 14:56","2017/12/29 18:39"};
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
        ((BusinessHolder)holder).icon.setImageResource(image[position]);
        ((BusinessHolder)holder).money.setText(list.get(position).getBusinessMoney());
        ((BusinessHolder)holder).time.setText(time[position]);
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
        TextView name,money,time;
        ImageView icon;
        public BusinessHolder(View view)
        {
            super(view);
            name = view.findViewById(R.id.iv_name);
            icon = view.findViewById(R.id.ciriv_user_icon);
            money = view.findViewById(R.id.wallet_money);
            time = view.findViewById(R.id.iv_time);

        }
    }
}
