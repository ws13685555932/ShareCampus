package com.wangsheng.sharecampus.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.adapter.CategoryPageAdapter;
import com.wangsheng.sharecampus.adapter.DrawerTaskOutAdapter;
import com.wangsheng.sharecampus.fragment.RecycleFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TaskOutActivity extends AppCompatActivity {
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.iv_back)
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_out);
        ButterKnife.bind(this);
        List<Fragment> fragList = new ArrayList<>();
        List<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("title","代取申通快递");
        map.put("time","今天10:26");
        map.put("showtimes","50次浏览");
        map.put("state","剩余20小时");
        map.put("price","3金");
        map.put("content","骏园一心楼下申通帐篷，明天中午前要拿走，送到我宿舍，具体私聊。");
        list.add(map);
        list.add(map);
        for (int i = 0; i < 4; i++) {
            RecycleFragment recycleFragment = new RecycleFragment();
            DrawerTaskOutAdapter adapter = new DrawerTaskOutAdapter(list,i+1,TaskOutActivity.this);
            recycleFragment.adapter = adapter;
            fragList.add(recycleFragment);
        }

        viewPager.setAdapter(new CategoryPageAdapter(getSupportFragmentManager(),fragList));
        tabLayout.setupWithViewPager(viewPager);

        String[] tabArr = new String[]{
                "待接收","进行中","待评价","已完成"
        };
        for (int i = 0; i < 4; i++) {
            tabLayout.getTabAt(i).setText(tabArr[i]);
        }
    }
    @OnClick({R.id.iv_back})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
        }
    }
}