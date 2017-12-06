package com.wangsheng.sharecampus.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.fragment.task.getTaskBean;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.wangsheng.sharecampus.MyApplication.getContext;


/**
 * Created by windows8 on 2017/10/1.
 */

public class MyCollectionActivity extends AppCompatActivity {
    @BindView(R.id.iv_back)
    ImageView back;
    @BindView(R.id.iv_recycle)
    RecyclerView recyclerView;
    private List<getTaskBean> list = new ArrayList<getTaskBean>();
    private GridLayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collection);
        ButterKnife.bind(this);
        list = new ArrayList<getTaskBean>();
        getTaskBean task = new getTaskBean();
        task.setPublisherName("李逸云");
        task.setTitle("高数高数");
        task.setDescription("高数3.1的15题怎么做啊，急急急急！！明天就要交作业了");
        task.setPuttime("21:30");
        task.setPrice(0.5);
        list.add(task);
        list.add(task);
        list.add(task);
        list.add(task);
        mLayoutManager=new GridLayoutManager(MyCollectionActivity.this,1,GridLayoutManager.VERTICAL,false);//设置为一个1列的纵向网格布局
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(new CommonAdapter<getTaskBean>(getContext(),R.layout.item_recy_coll_task,list) {
            @Override
            protected void convert(ViewHolder holder, getTaskBean o, final int position) {
                holder.setOnLongClickListener(R.id.coll_ll_task, new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        new AlertDialog.Builder(MyCollectionActivity.this).setTitle("提示：").setMessage("确认删除该收藏吗？")
                                .setPositiveButton("是", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        list.remove(position);
                                        notifyDataSetChanged();
                                    }
                                }).setNegativeButton("否", null).show();
                        return false;
                    }
                });
                holder.setOnClickListener(R.id.coll_ll_task, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MyCollectionActivity.this,TaskActivity.class);
                        TaskActivity.task = list.get(position);
                        startActivity(intent);
                    }
                });
                int[] image = {R.drawable.image_head1,R.drawable.image_head2,R.drawable.image_head3,R.drawable.image_head4,R.drawable.image_head5};
                ((TextView)holder.getView(R.id.task_title)).setText(list.get(position).getTitle());
                ((TextView)holder.getView(R.id.task_user_name)).setText(list.get(position).getPublisherName());
                ((TextView)holder.getView(R.id.task_price)).setText(list.get(position).getPrice()+"");
                ((TextView)holder.getView(R.id.task_content)).setText(list.get(position).getDescription());
                ((TextView)holder.getView(R.id.task_time)).setText(list.get(position).getPuttime());
                ((ImageView)holder.getView(R.id.civ_user_icon)).setImageResource(image[position%5]);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyCollectionActivity.this.finish();
            }
        });
    }
}
