package com.wangsheng.sharecampus.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.wangsheng.sharecampus.ApiService.TaskService;
import com.wangsheng.sharecampus.ApiServiceBean.TaskServiceRequest.TaskgetUserTaskRequest;
import com.wangsheng.sharecampus.ApiServiceBean.TaskServiceResponse.TaskgetTaskResponse;
import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.adapter.DrawerTaskOutAdapter;
import com.wangsheng.sharecampus.bean.ResponseInfoList;
import com.wangsheng.sharecampus.util.HttpManager;
import com.wangsheng.sharecampus.util.HttpObserverList;
import com.wangsheng.sharecampus.util.RxSchedulersHelper;
import com.wangsheng.sharecampus.util.SharedUtil;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;

/**
 * Created by windows8 on 2017/12/11.
 */

public class MyTaskRecycleFragment extends LazyFragment {
    private static final String TAG = "CategoryFragment";
    @BindView(R.id.alltask)
    PullLoadMoreRecyclerView recyclerView;
    Unbinder unbinder;

    List<TaskgetTaskResponse> list = new ArrayList<TaskgetTaskResponse>();
    DrawerTaskOutAdapter taskRecycleAdapter;
    public int type;
    private int pageNum = 1;

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
        recyclerView.setStaggeredGridLayout(1);
        taskRecycleAdapter = new DrawerTaskOutAdapter(list,type,getActivity());
        recyclerView.setAdapter(taskRecycleAdapter);
        recyclerView.setColorSchemeResources(R.color.colorPrimary);
        recyclerView.setFooterViewBackgroundColor(R.color.white);
        recyclerView.setFooterViewTextColor(R.color.colorPrimary);
        /*
        上拉加载更多
         */
        recyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                refreshData();
                recyclerView.setPullLoadMoreCompleted();
            }

            @Override
            public void onLoadMore() {
                recyclerView.setFooterViewText("正在加载");
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        //do something
                        getMoreData();
                        recyclerView.setPullLoadMoreCompleted();
                    }
                }, 1000);
            }
        });
        refreshData();
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
    }
    /*
    刷新数据
     */
    public void refreshData(){
        pageNum = 1;
        getData();
        getMoreData();
    }
    /*
    加载更多数据
     */
    public void getMoreData(){
        if(type<3){
            getUncompletedTask(pageNum);
        }
        else{
            getCompletedTask(pageNum);
        }
    }

    public List<TaskgetTaskResponse> getData(){
        List<TaskgetTaskResponse> tasks = new ArrayList<TaskgetTaskResponse>();
        TaskgetTaskResponse task = new TaskgetTaskResponse();
        task.setTitle("代取申通快递");
        task.setStarttime("2017-12-11 03:53:29");
        task.setEndtime("2017-12-11 03:53:29");
        task.setPrice(3);
        task.setDescription("骏园一心楼下申通帐篷，明天中午前要拿走，送到我宿舍，具体私聊。");
        list.add(task);
        list.add(task);
        return tasks;
    }
    private void getUncompletedTask(final int pagenum){
        TaskService taskService = HttpManager.getInstance().createService(TaskService.class);
        TaskgetUserTaskRequest user = new TaskgetUserTaskRequest();
        user.setPublisherId((int)SharedUtil.getParam("userId",10000));
        Observable<ResponseInfoList<JsonArray>> call = taskService.getUncompletedTasks(pagenum,10, user);
        call.compose(RxSchedulersHelper.<ResponseInfoList<JsonArray>>io_main())
                .subscribe(new HttpObserverList<JsonArray>() {
                    @Override
                    public void onSuccess(JsonArray tasklist,int pageNo) {
                        if(pageNo == pagenum){
                            JsonArray jsonArray = tasklist;
                            Gson gson = new Gson();
                            for (JsonElement task : jsonArray) {
                                TaskgetTaskResponse taskbean = gson.fromJson(task, TaskgetTaskResponse.class);
                                list.add(taskbean);
                            }
                            taskRecycleAdapter.notifyDataSetChanged();
                            pageNum++;
                        }
                        else{
                            Toast.makeText(getActivity(),"暂无更多",Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailed(String message) {
                        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void getCompletedTask(final int pagenum){
        TaskService taskService = HttpManager.getInstance().createService(TaskService.class);
        TaskgetUserTaskRequest user = new TaskgetUserTaskRequest();
        user.setPublisherId((int)SharedUtil.getParam("userId",10000));
        Observable<ResponseInfoList<JsonArray>> call = taskService.getCompletedTasks(pagenum,10, user);
        call.compose(RxSchedulersHelper.<ResponseInfoList<JsonArray>>io_main())
                .subscribe(new HttpObserverList<JsonArray>() {
                    @Override
                    public void onSuccess(JsonArray tasklist,int pageNo) {
                        if(pageNo == pagenum){
                            JsonArray jsonArray = tasklist;
                            Gson gson = new Gson();
                            for (JsonElement task : jsonArray) {
                                TaskgetTaskResponse taskbean = gson.fromJson(task, TaskgetTaskResponse.class);
                                list.add(taskbean);
                            }
                            taskRecycleAdapter.notifyDataSetChanged();
                            pageNum++;
                        }
                        else{
                            Toast.makeText(getActivity(),"暂无更多",Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailed(String message) {
                        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
                    }
                });
    }
}