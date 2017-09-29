package com.wangsheng.sharecampus.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.adapter.TaskRecycleAdapter;
import com.wangsheng.sharecampus.bean.Task;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangsheng
 * on 2017/9/27.
 *
 *
 * 首页任务界面,Viewpager下每个Item对应的Fragment
 */

public class CategoryFragment extends Fragment {
    private static final String TAG = "CategoryFragment";
    @BindView(R.id.alltask)
    RecyclerView recyclerView;
    Unbinder unbinder;
    List<Task> list = new ArrayList<Task>();
    private GridLayoutManager mLayoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alltask,container,false);
        unbinder = ButterKnife.bind(this,view);
        Log.d(TAG, "onCreateView: ");
//        Task task = new Task();
//        task.setTaskTitle("第1个任务");
//        list.add(task);
//        Task task2 = new Task();
//        task2.setTaskTitle("第2个任务");
//        list.add(task2);
//        task.setTaskTitle("第3个任务");
//        list.add(task);
//        mLayoutManager=new GridLayoutManager(getActivity(),1,GridLayoutManager.VERTICAL,false);//设置为一个1列的纵向网格布局
//        recyclerView.setLayoutManager(mLayoutManager);
//        TaskRecycleAdapter taskRecycleAdapter = new TaskRecycleAdapter(getActivity(),list);
//        recyclerView.setAdapter(taskRecycleAdapter);
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
