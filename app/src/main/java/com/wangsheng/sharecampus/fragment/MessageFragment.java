package com.wangsheng.sharecampus.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.view.DividerItemDecoration;
import com.wangsheng.sharecampus.view.MyLinearLayoutManager;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangsheng
 * on 2017/9/27.
 * <p>
 * 首页消息界面
 */

public class MessageFragment extends Fragment {

    @BindView(R.id.recycler_chat)
    RecyclerView recyclerChat;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        unbinder = ButterKnife.bind(this, view);

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

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
