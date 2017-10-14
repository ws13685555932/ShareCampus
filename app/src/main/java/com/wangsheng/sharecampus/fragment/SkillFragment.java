package com.wangsheng.sharecampus.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.adapter.SkillRecyclerAdapter;
import com.wangsheng.sharecampus.adapter.TaskRecycleAdapter;
import com.wangsheng.sharecampus.bean.SkillBean;
import com.wangsheng.sharecampus.bean.Task;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGABannerUtil;

/**
 * Created by wangsheng
 * on 2017/10/14.
 */

public class SkillFragment extends Fragment {
    @BindView(R.id.banner_ad)
    BGABanner bannerAd;
    @BindView(R.id.recycler_catogory)
    RecyclerView recyclerCatogory;
    Unbinder unbinder;

    private LinearLayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skill, container, false);
        unbinder = ButterKnife.bind(this, view);

        List<SkillBean> skillBeanList = new ArrayList<>();

        SkillBean bean = new SkillBean();
        bean.setCateId(0);
        bean.setSkillTotal("学长学姐");
        List<String> labelList = new ArrayList<>();
        labelList.add("考研");
        labelList.add("保研");
        labelList.add("公务员");
        labelList.add("工作");
        labelList.add("竞赛");
        labelList.add("考证");
        labelList.add("学生工作");
        labelList.add("文娱才艺");
        bean.setSkillList(labelList);
        skillBeanList.add(bean);

        SkillBean bean2 = new SkillBean();
        bean2.setCateId(1);
        bean2.setSkillTotal("学长学姐");
        List<String> labelList2 = new ArrayList<>();
        labelList2.add("计算机");
        labelList2.add("能源电力");
        labelList2.add("材料");
        labelList2.add("土木");
        labelList2.add("财务");
        labelList2.add("营销");
        labelList2.add("金融");
        labelList2.add("水利");
        labelList2.add("航空航天");
        labelList2.add("法律");
        bean2.setSkillList(labelList2);
        skillBeanList.add(bean2);


        SkillBean bean3 = new SkillBean();
        bean3.setCateId(2);
        bean3.setSkillTotal("学长学姐");
        List<String> labelList3 = new ArrayList<>();
        labelList3.add("IT");
        labelList3.add("金融");
        labelList3.add("建筑");
        labelList3.add("营销");
        labelList3.add("管理");
        labelList3.add("教育");
        bean3.setSkillList(labelList3);
        skillBeanList.add(bean3);

        SkillBean bean4 = new SkillBean();
        bean4.setCateId(3);
        bean4.setSkillTotal("学长学姐");
        List<String> labelList4 = new ArrayList<>();
        labelList4.add("山区支教");
        labelList4.add("关爱残疾");
        labelList4.add("抗险救灾");
        labelList4.add("跨国公益");
        bean4.setSkillList(labelList4);
        skillBeanList.add(bean4);





        List<View> views = new ArrayList<>();
        views.add(BGABannerUtil.getItemImageView(getActivity(), R.drawable.magic_girl));
        views.add(BGABannerUtil.getItemImageView(getActivity(), R.drawable.guilty_crown));
        views.add(BGABannerUtil.getItemImageView(getActivity(), R.drawable.magic_girl));
        bannerAd.setData(views);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerCatogory.setLayoutManager(manager);

        recyclerCatogory.setAdapter(new CommonAdapter<SkillBean>(getActivity(), R.layout.item_recy_skill, skillBeanList) {

            @Override
            protected void convert(ViewHolder holder, SkillBean skillBean, int position) {
                holder.setText(R.id.tv_skill, skillBean.getSkillTotal());
                GridView grid = holder.getView(R.id.grid_skill);
                RelativeLayout rlBackground = holder.getView(R.id.rl_background);
                switch (skillBean.getCateId()) {
                    case 0:
                        rlBackground.setBackgroundColor(getResources().getColor(R.color.skill_color1));
                        break;
                    case 1:
                        rlBackground.setBackgroundColor(getResources().getColor(R.color.skill_color2));
                        break;
                    case 2:
                        rlBackground.setBackgroundColor(getResources().getColor(R.color.skill_color3));
                        break;
                    case 3:
                        rlBackground.setBackgroundColor(getResources().getColor(R.color.skill_color4));
                        break;
                }
                List<String> labelList = skillBean.getSkillList();
                grid.setAdapter(new com.zhy.adapter.abslistview.CommonAdapter<String>(
                        getActivity(), R.layout.item_grid_skill, labelList) {
                    @Override
                    protected void convert(com.zhy.adapter.abslistview.ViewHolder viewHolder, String item, int position) {
                        viewHolder.setText(R.id.tv_skill, item);
                    }
                });
            }
        });


//        mLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
//        recyclerCatogory.setLayoutManager(mLayoutManager);
//        SkillRecyclerAdapter adapter = new SkillRecyclerAdapter(getActivity(),skillBeanList);
//        recyclerCatogory.setAdapter(adapter);

        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
