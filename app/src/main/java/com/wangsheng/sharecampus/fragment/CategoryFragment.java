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
import com.wangsheng.sharecampus.ApiServiceBean.TaskServiceRequest.TaskSearchByCategoryRequest;
import com.wangsheng.sharecampus.ApiServiceBean.TaskServiceResponse.TaskgetTaskResponse;
import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.adapter.TaskRecycleAdapter;
import com.wangsheng.sharecampus.bean.ResponseInfoList;
import com.wangsheng.sharecampus.util.HttpManager;
import com.wangsheng.sharecampus.util.HttpObserverList;
import com.wangsheng.sharecampus.util.RxSchedulersHelper;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;

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
    PullLoadMoreRecyclerView recyclerView;
    Unbinder unbinder;

    List<TaskgetTaskResponse> list = new ArrayList<TaskgetTaskResponse>();
    TaskRecycleAdapter taskRecycleAdapter;
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
        list = getData(type);
        recyclerView.setStaggeredGridLayout(2);
        taskRecycleAdapter = new TaskRecycleAdapter(getActivity(),list);
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
    public void getMoreData(){
        getTask(pageNum);
    }
    public static final int STUDYANSWER = 1;//学习提问
    public static final int LIFEHELP = 2;//生活提问
    public static final int PURCHASINGAGENT = 3;//代取代购
    public static final int LOSTANDFOUND = 4;//失物招领
    public static final int MATCHTEAMMATE = 5;//竞赛队友
    public static final int FRIENDS = 6;//考研研友
    public static final int RENT = 7;//物品租借
    public static final int COMPUTERREPAIR = 8;//物品维修
    public static final int BODYBUILDING = 9;//健身伙伴
    public static final int TAKINGPHOTO = 10;//摄影剪辑
    public static final int PS = 11;//修图海报
    public static final int PARTTIMEJOB = 12;//兼职同行
    public List<TaskgetTaskResponse> getData(int type){
        List<TaskgetTaskResponse> tasks = new ArrayList<TaskgetTaskResponse>();
        switch (type){
            case STUDYANSWER:
                TaskgetTaskResponse task = new TaskgetTaskResponse();
                task.setPublisherName("李逸云");
                task.setTitle("高数高数");
                task.setDescription("高数3.1的15题怎么做啊，急急急急！！明天就要交作业了");
                task.setPuttime("21:30");
                task.setPrice(0.5);
                tasks.add(task);
                TaskgetTaskResponse task2 = new TaskgetTaskResponse();
                task2.setPublisherName("陈彦儒");
                task2.setTitle("大物实在是太难了");
                task2.setDescription("急求大物第三版大一下的课后答案！！");
                task2.setPuttime("22.26");
                task2.setPrice(5);
                tasks.add(task2);
                TaskgetTaskResponse task3 = new TaskgetTaskResponse();
                task3.setPublisherName("张鹏哲");
                task3.setTitle("法律问题");
                task3.setDescription("王某有一栋可以眺望海景的别墅，当他得知有一栋大楼将要建设，" +
                        "从此别墅不能再眺望海景时，就将别墅卖给想得到一套可以眺望海景的房屋的张某" +
                        "，王某的行为违背了民法哪一原则？");
                task3.setPuttime("21:29");
                task3.setPrice(0.2);
                tasks.add(task3);
                TaskgetTaskResponse task4 = new TaskgetTaskResponse();
                task4.setPublisherName("罗春梅");
                task4.setTitle("上课的地址");
                task4.setDescription("有没有人知道人工智能的课表啊，想去蹭蹭课，了解一下新知识");
                task4.setPuttime("15:30");
                task4.setPrice(0);
                tasks.add(task4);
                TaskgetTaskResponse task5 = new TaskgetTaskResponse();
                task5.setPublisherName("王胜");
                task5.setTitle("关于android");
                task5.setDescription("谁有没有一个好的入门android的博客地址或书推荐一下呗");
                task5.setPuttime("10:30");
                task5.setPrice(0);
                tasks.add(task5);
                TaskgetTaskResponse task6 = new TaskgetTaskResponse();
                task6.setPublisherName("彭小野");
                task6.setTitle("用c++编程");
                task6.setDescription("编写一个函数，函数接收一个字符串,是由十六进制数组成的一组" +
                        "字符串,函数的功能是把接到的这组字符串转换成十进制数字.并将十进制数字返回。");
                task6.setPuttime("12:30");
                task6.setPrice(1.5);
                tasks.add(task6);
                return tasks;
            case LIFEHELP:
                TaskgetTaskResponse task7 = new TaskgetTaskResponse();
                task7.setPublisherName("李逸云");
                task7.setTitle("绯云苑在哪儿？？");
                task7.setDescription("申通发到了青年城这个地方有点蒙蔽。。。");
                task7.setPuttime("21:30");
                task7.setPrice(0);
                tasks.add(task7);
                TaskgetTaskResponse task8 = new TaskgetTaskResponse();
                task8.setPublisherName("陈彦儒");
                task8.setTitle("麻烦问一下在哪儿能租到服装啊");
                task8.setDescription("社团办活动需要租一些道具服装，跪求地址");
                task8.setPuttime("22.26");
                task8.setPrice(2);
                tasks.add(task8);
                TaskgetTaskResponse task9 = new TaskgetTaskResponse();
                task9.setPublisherName("张鹏哲");
                task9.setTitle("提个小问题");
                task9.setDescription("宿舍用洗衣机阿姨会说的吗？？有谁用过啊");
                task9.setPuttime("21:29");
                task9.setPrice(0.2);
                tasks.add(task9);
                TaskgetTaskResponse task10 = new TaskgetTaskResponse();
                task10.setPublisherName("罗春梅");
                task10.setTitle("养的一只小猫丢了，求助帮找一下");
                task10.setDescription("养了半年多了很有感情，应该是门没关好自己走出去的，头顶有一" +
                        "些黄毛，左眼黑眼圈，通体白猫，找到者可以打我电话啊1343434334");
                task10.setPuttime("15:30");
                task10.setPrice(10);
                tasks.add(task10);
                TaskgetTaskResponse task11 = new TaskgetTaskResponse();
                task11.setPublisherName("王胜");
                task11.setTitle("谁知道哪里订牛奶啊");
                task11.setDescription("如题如题");
                task11.setPuttime("10:30");
                task11.setPrice(0);
                tasks.add(task11);
                TaskgetTaskResponse task12 = new TaskgetTaskResponse();
                task12.setPublisherName("彭小野");
                task12.setTitle("求一波gank");
                task12.setDescription("最近骏园广场天天中午放歌，烦死了，谁帮我把他们炸了");
                task12.setPuttime("12:30");
                task12.setPrice(20);
                tasks.add(task12);
                return tasks;
        }
        return tasks;
    }
    private void getTask(final int pagenum){
        TaskService taskService = HttpManager.getInstance().createService(TaskService.class);
        TaskSearchByCategoryRequest task = new TaskSearchByCategoryRequest();
        task.setCategory(type);
        Observable<ResponseInfoList<JsonArray>> call = taskService.searchTaskByCategory(pagenum,20, task);
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
