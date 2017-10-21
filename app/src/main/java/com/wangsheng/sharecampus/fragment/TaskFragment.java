package com.wangsheng.sharecampus.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.activity.MainActivity;
import com.wangsheng.sharecampus.activity.SearchActivity;
import com.wangsheng.sharecampus.adapter.CategoryPageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
    @BindView(R.id.ll_search)
    LinearLayout llsearch;
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
        for (int i = 0; i < 12; i++) {
            CategoryFragment categoryFragment = new CategoryFragment();
            categoryFragment.type = i+1;
            fragList.add(categoryFragment);
        }

        viewPager.setAdapter(new CategoryPageAdapter(getFragmentManager(),fragList));
        tabLayout.setupWithViewPager(viewPager);

        String[] tabArr = new String[]{
                "学习提问","生活提问","代取代购","失物招领",
                "竞赛队友", "考研研友","物品租借","物品维修",
                "健身伙伴", "摄影剪辑","修图海报","兼职同行",
        };
        for (int i = 0; i < 12; i++) {
            tabLayout.getTabAt(i).setText(tabArr[i]);
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @OnClick(R.id.ciriv_user_icon)
    public void openDrawer(){
        MainActivity.drawer.openDrawer(Gravity.LEFT,true);
    }
    @OnClick({R.id.ll_search})
    public void onclick(View v){
        switch (v.getId()){
            case R.id.ll_search:
                SearchActivity.TYPE = "TASK";
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
                break;
        }
    }
}
