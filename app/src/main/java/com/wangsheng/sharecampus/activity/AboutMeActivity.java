package com.wangsheng.sharecampus.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.adapter.CategoryPageAdapter;
import com.wangsheng.sharecampus.fragment.CategoryFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutMeActivity extends AppCompatActivity {

    @BindView(R.id.imageview)
    ImageView ivMyBg;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        ButterKnife.bind(this);

        Glide.with(this)
                .load(R.drawable.guilty_crown)
                .into(ivMyBg);

        List<Fragment> fragList = new ArrayList<>();
        CategoryFragment cate1 = new CategoryFragment();
        CategoryFragment cate2 = new CategoryFragment();
        CategoryFragment cate3 = new CategoryFragment();

        fragList.add(cate1);
        fragList.add(cate2);
        fragList.add(cate3);

        viewPager.setAdapter(new CategoryPageAdapter(getSupportFragmentManager(), fragList));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("ta发出的");
        tabLayout.getTabAt(1).setText("ta接收的");
        tabLayout.getTabAt(2).setText("关于ta");
    }
}
