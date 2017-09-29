package com.wangsheng.sharecampus.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.adapter.CategoryPageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by wangsheng
 * on 2017/9/27.
 *
 * 首页任务界面
 */

public class TaskFragment extends Fragment {
    @BindView(R.id.ciriv_user_icon)
    CircleImageView cirivUserIcon;
    @BindView(R.id.iv_location)
    ImageView ivLocation;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        unbinder = ButterKnife.bind(this, view);

        List<Fragment> fragList = new ArrayList<>();
        CategoryFragment cate1 = new CategoryFragment();
        CategoryFragment cate2 = new CategoryFragment();
        CategoryFragment cate3 = new CategoryFragment();

        fragList.add(cate1);
        fragList.add(cate2);
        fragList.add(cate3);

        viewPager.setAdapter(new CategoryPageAdapter(getFragmentManager(),fragList));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("全部");
        tabLayout.getTabAt(1).setText("找人");
        tabLayout.getTabAt(2).setText("办事");
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
