package com.wangsheng.sharecampus.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.view.DividerItemDecoration;
import com.wangsheng.sharecampus.view.MyLinearLayoutManager;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.wangsheng.sharecampus.MyApplication.getContext;

/**
 * Created by wangsheng
 * on 2017/9/27.
 * <p>
 * 首页消息界面
 */

public class MessageActivity extends AppCompatActivity {

    @BindView(R.id.recycler_chat)
    RecyclerView recyclerChat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        recyclerChat.setAdapter(new CommonAdapter<String>(getContext(),R.layout.item_recy_chat,list) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {

            }
        });

        MyLinearLayoutManager layoutManager = new MyLinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerChat.setLayoutManager(layoutManager);
        recyclerChat.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL_LIST));
    }
}
