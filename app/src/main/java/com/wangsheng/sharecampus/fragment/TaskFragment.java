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
        for (int i = 0; i < 14; i++) {
            fragList.add(new CategoryFragment());
        }

        viewPager.setAdapter(new CategoryPageAdapter(getFragmentManager(),fragList));
        tabLayout.setupWithViewPager(viewPager);

        String[] tabArr = new String[]{
                "学习答疑","生活帮助","学习辅导","代取代购","物品租借",
                "电脑维修","失物招领","竞赛队友","合租室友",
                "考研研友","健身伙伴","摄影剪辑","修图海报", "兼职同行"
        };
        for (int i = 0; i < 14; i++) {
            tabLayout.getTabAt(i).setText(tabArr[i]);
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
