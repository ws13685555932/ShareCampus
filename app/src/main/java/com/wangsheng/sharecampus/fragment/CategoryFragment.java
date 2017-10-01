package com.wangsheng.sharecampus.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangsheng.sharecampus.Bean.Task;
import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.adapter.TaskRecycleAdapter;

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

public class CategoryFragment extends LazyFragment {
    private static final String TAG = "CategoryFragment";
    @BindView(R.id.alltask)
    RecyclerView recyclerView;
    @BindView(R.id.task_swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    Unbinder unbinder;
    List<Task> list = new ArrayList<Task>();
    TaskRecycleAdapter taskRecycleAdapter;
    private GridLayoutManager mLayoutManager;
    int lastVisibleItem;
    int page = 0;
    boolean isLoading = false;//用来控制进入getdata()的次数
    int totlePage = 2;//模拟请求的一共的页数


    public CategoryFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catetory,container,false);
        unbinder = ButterKnife.bind(this,view);

        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    protected void onFragmentFirstVisible() {
        Task task = new Task();
        task.setTaskTitle("第1个任务");
        list.add(task);

        Task task2 = new Task();
        task2.setTaskTitle("第2个任务");
        list.add(task2);

        Task task3 = new Task();
        task3.setTaskTitle("第3个任务");
        list.add(task3);
        list.add(task3);
        list.add(task3);
        list.add(task3);
        list.add(task3);
        list.add(task3);
        list.add(task3);
        list.add(task3);

        mLayoutManager=new GridLayoutManager(getActivity(),1,GridLayoutManager.VERTICAL,false);//设置为一个1列的纵向网格布局
        recyclerView.setLayoutManager(mLayoutManager);
        taskRecycleAdapter = new TaskRecycleAdapter(getActivity(),list);
        recyclerView.setAdapter(taskRecycleAdapter);
        /*
        下拉刷新
         */
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            public void onRefresh() {
                refreshData();
                taskRecycleAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        /*
        上拉加载更多
         */
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == taskRecycleAdapter.getItemCount() && !isLoading) {
                    if (page < totlePage) {
                        isLoading = true;
                        taskRecycleAdapter.changeState(1);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                getData();
                                page++;
                            }
                        }, 2000);
                    } else {
                        taskRecycleAdapter.changeState(2);

                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //拿到最后一个出现的item的位置
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            }
        });

    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
    }
    /*
    刷新数据
     */
    public void refreshData(){

    }
    /*
    加载更多数据
     */
    public void getData(){
        Task task = new Task();
        task.setTaskTitle("新加载的任务");
        list.add(task);
        list.add(task);
        isLoading = false;
        taskRecycleAdapter.notifyDataSetChanged();
    }

}
