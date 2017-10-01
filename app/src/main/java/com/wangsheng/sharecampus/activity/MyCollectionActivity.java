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
import com.wangsheng.sharecampus.fragment.CollectionFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by windows8 on 2017/10/1.
 */

public class MyCollectionActivity extends AppCompatActivity {
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.iv_back)ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collection);
        ButterKnife.bind(this);
        List<Fragment> fragList = new ArrayList<>();
        CollectionFragment cate1 = new CollectionFragment(0);
        CollectionFragment cate2 = new CollectionFragment(1);

        fragList.add(cate1);
        fragList.add(cate2);

        viewPager.setAdapter(new CategoryPageAdapter(getSupportFragmentManager(),fragList));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("收藏的人");
        tabLayout.getTabAt(1).setText("收藏的任务");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyCollectionActivity.this.finish();
            }
        });
    }
}
