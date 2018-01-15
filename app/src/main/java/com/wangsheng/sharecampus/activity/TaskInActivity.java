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
import com.wangsheng.sharecampus.fragment.MyTaskRecycleFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TaskInActivity extends AppCompatActivity {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.iv_back)
    ImageView back;

    List<Fragment> fragList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_in);
        ButterKnife.bind(this);
        for (int i = 0; i < 4; i++) {
            MyTaskRecycleFragment recycleFragment = new MyTaskRecycleFragment();
            recycleFragment.type = i+1;
            fragList.add(recycleFragment);
        }

        viewPager.setAdapter(new CategoryPageAdapter(getSupportFragmentManager(),fragList));
        tabLayout.setupWithViewPager(viewPager);

        String[] tabArr = new String[]{
                "悬赏","通缉","集市"
        };
        for (int i = 0; i < 3; i++) {
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
