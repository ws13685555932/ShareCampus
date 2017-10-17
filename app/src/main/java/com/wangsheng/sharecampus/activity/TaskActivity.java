package com.wangsheng.sharecampus.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.bean.Task;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TaskActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.recycler_leave_message)
    RecyclerView recyclerLeaveMessage;
    @BindView(R.id.nsv_parent)
    NestedScrollView nsvParent;
    @BindView(R.id.btn_accept)
    Button btnAccept;
    @BindView(R.id.grid_pics)
    GridView gridPics;
    @BindView(R.id.task_title)TextView title;
    @BindView(R.id.task_content)TextView content;
    @BindView(R.id.task_price)TextView price;
    @BindView(R.id.task_user_name)TextView name;
    @BindView(R.id.back)ImageView back;
    @BindView(R.id.task_time)TextView time;
    public static Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        ButterKnife.bind(this);

        ArrayList<String> list = new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("java");

        recyclerLeaveMessage.setAdapter(new CommonAdapter<String>(this, R.layout.item_recy_leave_message, list) {
            @Override
            protected void convert(ViewHolder holder, String o, int position) {

            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerLeaveMessage.setLayoutManager(layoutManager);

        recyclerLeaveMessage.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(0, 0, 0, 1);
            }

        });

        recyclerLeaveMessage.setFocusable(false);

        List<Integer> resIds = new ArrayList<>();
        resIds.add(R.drawable.kangna);
        resIds.add(R.drawable.kangna);
        resIds.add(R.drawable.kangna);
        resIds.add(R.drawable.kangna);
        gridPics.setAdapter(new com.zhy.adapter.abslistview.CommonAdapter<Integer>(this,R.layout.item_grid_picd,resIds) {

            @Override
            protected void convert(com.zhy.adapter.abslistview.ViewHolder viewHolder, Integer item, int position) {

            }
        });
        title.setText(task.getTaskTitle());
        content.setText(task.getTaskContent());
        price.setText("悬赏金额：￥"+task.getTaskPrice());
        name.setText(task.getCreaterName());
        time.setText("发布于2016年10月15日 "+task.getCreateTime());
        back.setOnClickListener(this);
    }

    @OnClick(R.id.btn_accept)
    public void onViewClicked() {
        Intent intent = new Intent(this, TaskAcceptActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                TaskActivity.this.finish();
                break;
        }
    }
}
