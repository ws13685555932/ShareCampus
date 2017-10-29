package com.wangsheng.sharecampus.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.bean.Task;
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

public class MyConcernActivity extends AppCompatActivity {
    @BindView(R.id.iv_back)
    ImageView back;
    @BindView(R.id.iv_recycle)
    RecyclerView recyclerView;
    private List<Task> list = new ArrayList<Task>();
    private GridLayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_concern);
        ButterKnife.bind(this);
        list = new ArrayList<Task>();
        Task task1 = new Task();
        task1.setTaskTitle("第一个任务");
        list.add(task1);
        list.add(task1);
        list.add(task1);
        mLayoutManager=new GridLayoutManager(MyConcernActivity.this,1,GridLayoutManager.VERTICAL,false);//设置为一个1列的纵向网格布局
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(new CommonAdapter<Task>(getContext(),R.layout.item_recy_coll_person,list) {
            @Override
            protected void convert(ViewHolder holder, Task o, final int position) {
                holder.setOnLongClickListener(R.id.coll_per_ll, new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        new AlertDialog.Builder(MyConcernActivity.this).setTitle("提示：").setMessage("确认取消关注此人吗？")
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
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyConcernActivity.this.finish();
            }
        });
    }
}
