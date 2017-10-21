package com.wangsheng.sharecampus.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.activity.MainActivity;
import com.wangsheng.sharecampus.activity.SearchActivity;
import com.wangsheng.sharecampus.bean.SkillBean;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGABannerUtil;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by wangsheng
 * on 2017/10/14.
 */

public class SkillFragment extends Fragment {
    @BindView(R.id.banner_ad)
    BGABanner bannerAd;
    @BindView(R.id.recycler_catogory)
    RecyclerView recyclerCatogory;
    @BindView(R.id.ciriv_user_icon)
    CircleImageView icon;
    @BindView(R.id.ll_search)
    LinearLayout llsearch;
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
        bean.setSkillTotal("优秀学生");
        List<String> labelList = new ArrayList<>();
        labelList.add("考研");
        labelList.add("保研");
        labelList.add("工作");
        labelList.add("校园");
        bean.setSkillList(labelList);
        skillBeanList.add(bean);

        SkillBean bean2 = new SkillBean();
        bean2.setCateId(1);
        bean2.setSkillTotal("高校教师");
        List<String> labelList2 = new ArrayList<>();
        labelList2.add("理科");
        labelList2.add("工科");
        labelList2.add("文科");
        labelList2.add("其他");
        bean2.setSkillList(labelList2);
        skillBeanList.add(bean2);


        SkillBean bean3 = new SkillBean();
        bean3.setCateId(2);
        bean3.setSkillTotal("行业大牛");
        List<String> labelList3 = new ArrayList<>();
        labelList3.add("政治");
        labelList3.add("IT");
        labelList3.add("商业");
        labelList3.add("教育");
        bean3.setSkillList(labelList3);
        skillBeanList.add(bean3);

        SkillBean bean4 = new SkillBean();
        bean4.setCateId(3);
        bean4.setSkillTotal("公益人士");
        List<String> labelList4 = new ArrayList<>();
        labelList4.add("山区支教");
        labelList4.add("关爱残疾");
        labelList4.add("抗险救灾");
        labelList4.add("跨国公益");
        bean4.setSkillList(labelList4);
        skillBeanList.add(bean4);





        List<View> views = new ArrayList<>();
        views.add(BGABannerUtil.getItemImageView(getActivity(), R.drawable.bg_viewpager_main));
        views.add(BGABannerUtil.getItemImageView(getActivity(), R.drawable.magic_girl));
        views.add(BGABannerUtil.getItemImageView(getActivity(), R.drawable.magic_girl));
        bannerAd.setData(views);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerCatogory.setLayoutManager(manager);

        recyclerCatogory.setAdapter(new CommonAdapter<SkillBean>(getActivity(), R.layout.item_recy_skill, skillBeanList) {

            @Override
            protected void convert(ViewHolder holder, final SkillBean skillBean, int position) {
                holder.setText(R.id.tv_skill, skillBean.getSkillTotal());
                GridView grid = holder.getView(R.id.grid_skill);
                TextView title = holder.getView(R.id.tv_skill);
                switch (skillBean.getCateId()) {
                    case 0:
                        title.setBackgroundColor(getResources().getColor(R.color.skill_color1));
                        title.setText("优秀学生");
                        break;
                    case 1:
                        title.setBackgroundColor(getResources().getColor(R.color.skill_color2));
                        title.setText("高校教师");
                        break;
                    case 2:
                        title.setBackgroundColor(getResources().getColor(R.color.skill_color3));
                        title.setText("行业大牛");
                        break;
                    case 3:
                        title.setBackgroundColor(getResources().getColor(R.color.skill_color4));
                        break;
                }
                List<String> labelList = skillBean.getSkillList();
                grid.setAdapter(new com.zhy.adapter.abslistview.CommonAdapter<String>(
                        getActivity(), R.layout.item_grid_skill, labelList) {
                    @Override
                    protected void convert(com.zhy.adapter.abslistview.ViewHolder viewHolder, String item, int position) {
                        viewHolder.setText(R.id.tv_skill, item);
                        switch (skillBean.getCateId()) {
                            case 0:
                                viewHolder.setBackgroundColor(R.id.tv_skill,getResources().getColor(R.color.skill_color1));
                                break;
                            case 1:
                                viewHolder.setBackgroundColor(R.id.tv_skill,getResources().getColor(R.color.skill_color2));
                                break;
                            case 2:
                                viewHolder.setBackgroundColor(R.id.tv_skill,getResources().getColor(R.color.skill_color3));
                                break;
                            case 3:
                                viewHolder.setBackgroundColor(R.id.tv_skill,getResources().getColor(R.color.skill_color4));
                                break;
                        }
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
    @OnClick(R.id.ciriv_user_icon)
    public void openDrawer(){
        MainActivity.drawer.openDrawer(Gravity.LEFT,true);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @OnClick({R.id.ll_search})
    public void onclick(View v){
        switch (v.getId()){
            case R.id.ll_search:
                SearchActivity.TYPE = "SKILL";
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
                break;
        }
    }
}
