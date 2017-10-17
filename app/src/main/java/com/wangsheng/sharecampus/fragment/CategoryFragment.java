package com.wangsheng.sharecampus.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.adapter.TaskRecycleAdapter;
import com.wangsheng.sharecampus.bean.Task;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

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
    PullLoadMoreRecyclerView recyclerView;
    Unbinder unbinder;

    List<Task> list = new ArrayList<Task>();
    TaskRecycleAdapter taskRecycleAdapter;
    private int type;

    public CategoryFragment(int type) {
        this.type = type;
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
                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        //execute the task
                        getMoreData();
                    }
                }, 2000);
                recyclerView.setPullLoadMoreCompleted();
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
        Task task = new Task();
        task.setCreaterName("李逸云");
        task.setTaskTitle("高数高数");
        task.setTaskContent("高数3.1的15题怎么做啊，急急急急！！明天就要交作业了");
        task.setCreateTime("21:30");
        task.setTaskPrice(0.5);
        list.add(task);
        taskRecycleAdapter.notifyDataSetChanged();
    }
    public static final int STUDYANSWER = 1;//学习答疑
    public static final int LIFEHELP = 2;//生活帮助
    public static final int STUDYHELP = 3;//学习辅导
    public static final int PURCHASINGAGENT = 4;//代取代购
    public static final int RENT = 5;//物品租借
    public static final int COMPUTERREPAIR = 6;//电脑维修
    public static final int LOSTANDFOUND = 7;//失物招领
    public static final int MATCHTEAMMATE = 8;//竞赛队友
    public static final int ROOMMATESHARING = 9;//合租室友
    public static final int FRIENDS = 10;//考研研友
    public static final int BODYBUILDING = 11;//健身伙伴
    public static final int TAKINGPHOTO = 12;//摄影剪辑
    public static final int PS = 13;//修图海报
    public static final int PARTTIMEJOB = 14;//兼职同行
    public List<Task> getData(int type){
        List<Task> tasks = new ArrayList<Task>();
        switch (type){
            case STUDYANSWER:
                Task task = new Task();
                task.setCreaterName("李逸云");
                task.setTaskTitle("高数高数");
                task.setTaskContent("高数3.1的15题怎么做啊，急急急急！！明天就要交作业了");
                task.setCreateTime("21:30");
                task.setTaskPrice(0.5);
                tasks.add(task);
                Task task2 = new Task();
                task2.setCreaterName("陈彦儒");
                task2.setTaskTitle("大物实在是太难了");
                task2.setTaskContent("急求大物第三版大一下的课后答案！！");
                task2.setCreateTime("22.26");
                task2.setTaskPrice(5);
                tasks.add(task2);
                Task task3 = new Task();
                task3.setCreaterName("张鹏哲");
                task3.setTaskTitle("法律问题");
                task3.setTaskContent("王某有一栋可以眺望海景的别墅，当他得知有一栋大楼将要建设，" +
                        "从此别墅不能再眺望海景时，就将别墅卖给想得到一套可以眺望海景的房屋的张某" +
                        "，王某的行为违背了民法哪一原则？");
                task3.setCreateTime("21:29");
                task3.setTaskPrice(0.2);
                tasks.add(task3);
                Task task4 = new Task();
                task4.setCreaterName("罗春梅");
                task4.setTaskTitle("上课的地址");
                task4.setTaskContent("有没有人知道人工智能的课表啊，想去蹭蹭课，了解一下新知识");
                task4.setCreateTime("15:30");
                task4.setTaskPrice(0);
                tasks.add(task4);
                Task task5 = new Task();
                task5.setCreaterName("王胜");
                task5.setTaskTitle("关于android");
                task5.setTaskContent("谁有没有一个好的入门android的博客地址或书推荐一下呗");
                task5.setCreateTime("10:30");
                task5.setTaskPrice(0);
                tasks.add(task5);
                Task task6 = new Task();
                task6.setCreaterName("彭小野");
                task6.setTaskTitle("用c++编程");
                task6.setTaskContent("编写一个函数，函数接收一个字符串,是由十六进制数组成的一组" +
                        "字符串,函数的功能是把接到的这组字符串转换成十进制数字.并将十进制数字返回。");
                task6.setCreateTime("12:30");
                task6.setTaskPrice(1.5);
                tasks.add(task6);
                return tasks;
            case LIFEHELP:
                Task task7 = new Task();
                task7.setCreaterName("李逸云");
                task7.setTaskTitle("绯云苑在哪儿？？");
                task7.setTaskContent("申通发到了青年城这个地方有点蒙蔽。。。");
                task7.setCreateTime("21:30");
                task7.setTaskPrice(0);
                tasks.add(task7);
                Task task8 = new Task();
                task8.setCreaterName("陈彦儒");
                task8.setTaskTitle("麻烦问一下在哪儿能租到服装啊");
                task8.setTaskContent("社团办活动需要租一些道具服装，跪求地址");
                task8.setCreateTime("22.26");
                task8.setTaskPrice(2);
                tasks.add(task8);
                Task task9 = new Task();
                task9.setCreaterName("张鹏哲");
                task9.setTaskTitle("提个小问题");
                task9.setTaskContent("宿舍用洗衣机阿姨会说的吗？？有谁用过啊");
                task9.setCreateTime("21:29");
                task9.setTaskPrice(0.2);
                tasks.add(task9);
                Task task10 = new Task();
                task10.setCreaterName("罗春梅");
                task10.setTaskTitle("养的一只小猫丢了，求助帮找一下");
                task10.setTaskContent("养了半年多了很有感情，应该是门没关好自己走出去的，头顶有一" +
                        "些黄毛，左眼黑眼圈，通体白猫，找到者可以打我电话啊1343434334");
                task10.setCreateTime("15:30");
                task10.setTaskPrice(10);
                tasks.add(task10);
                Task task11 = new Task();
                task11.setCreaterName("王胜");
                task11.setTaskTitle("谁知道哪里订牛奶啊");
                task11.setTaskContent("如题如题");
                task11.setCreateTime("10:30");
                task11.setTaskPrice(0);
                tasks.add(task11);
                Task task12 = new Task();
                task12.setCreaterName("彭小野");
                task12.setTaskTitle("求一波gank");
                task12.setTaskContent("最近骏园广场天天中午放歌，烦死了，谁帮我把他们炸了");
                task12.setCreateTime("12:30");
                task12.setTaskPrice(20);
                tasks.add(task12);
                return tasks;
            case STUDYHELP:
                break;
            case PURCHASINGAGENT:
                break;
            case RENT:
                break;
            case COMPUTERREPAIR:
                break;
            case LOSTANDFOUND:
                break;
            case MATCHTEAMMATE:
                break;
            case ROOMMATESHARING:
                break;
            case FRIENDS:
                break;
            case BODYBUILDING:
                break;
            case TAKINGPHOTO:
                break;
            case PS:
                break;
            case PARTTIMEJOB:
                break;
        }
        return null;
    }
}
