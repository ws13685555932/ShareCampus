package com.wangsheng.sharecampus.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.activity.CheckclassSkillActivity;
import com.wangsheng.sharecampus.adapter.SkillRecyclerAdapter;
import com.wangsheng.sharecampus.view.MyLinearLayoutManager;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
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
    @BindView(R.id.skill_hrecycler)
    RecyclerView hrecyclerView;
    @BindView(R.id.skill_vrecycler_man)
    RecyclerView vrecyclerView_man;
    @BindView(R.id.skill_vrecycler_theme)
    RecyclerView vrecyclerView_theme;
    Unbinder unbinder;
    List<HashMap<String,Object>> list_h = new ArrayList<HashMap<String,Object>>();
    List<HashMap<String,Object>> list_v_man = new ArrayList<HashMap<String,Object>>();
    List<HashMap<String,Object>> list_v_theme = new ArrayList<HashMap<String,Object>>();

    private LinearLayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skill, container, false);
        unbinder = ButterKnife.bind(this, view);
        LinearLayoutManager ms= new LinearLayoutManager(getActivity());
        ms.setOrientation(LinearLayoutManager.HORIZONTAL);// 设置 recyclerview 布局方式为横向布局
        hrecyclerView.setLayoutManager(ms);
        initData();
        CommonAdapter adapter = new CommonAdapter<HashMap<String,Object>>(getActivity(),R.layout.item_recy_skill_h,list_h) {
            @Override
            protected void convert(ViewHolder holder, HashMap<String,Object> o, final int position) {
                ((TextView)holder.getView(R.id.theme)).setText(o.get("title").toString());
                ((TextView)holder.getView(R.id.entheme)).setText(o.get("entitle").toString());
                holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CheckclassSkillActivity.pagenum = position;
                        Intent classcheck = new Intent(getActivity(), CheckclassSkillActivity.class);
                        startActivity(classcheck);
                    }
                });
            }
        };
        hrecyclerView.setAdapter(adapter);
        MyLinearLayoutManager vr = new MyLinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        vrecyclerView_man.setAdapter(new SkillRecyclerAdapter(list_v_theme,getActivity()).getAdapter());
        vrecyclerView_man.setNestedScrollingEnabled(false);
        vrecyclerView_man.setHasFixedSize(true);
        vrecyclerView_man.setNestedScrollingEnabled(false);
        vrecyclerView_man.setLayoutManager(vr);
        MyLinearLayoutManager vr2 = new MyLinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);;
        vrecyclerView_theme.setAdapter(new SkillRecyclerAdapter(list_v_theme,getActivity()).getAdapter());
        vrecyclerView_theme.setNestedScrollingEnabled(false);
        vrecyclerView_theme.setHasFixedSize(true);
        vrecyclerView_theme.setNestedScrollingEnabled(false);
        vrecyclerView_theme.setLayoutManager(vr2);
        List<View> views = new ArrayList<>();
        views.add(BGABannerUtil.getItemImageView(getActivity(), R.drawable.bg_viewpager_main));
        views.add(BGABannerUtil.getItemImageView(getActivity(), R.drawable.magic_girl));
        views.add(BGABannerUtil.getItemImageView(getActivity(), R.drawable.magic_girl));
        bannerAd.setData(views);

//        List<SkillBean> skillBeanList = new ArrayList<>();
//
//        SkillBean bean = new SkillBean();
//        bean.setCateId(0);
//        bean.setSkillTotal("优秀学生");
//        List<String> labelList = new ArrayList<>();
//        labelList.add("考研");
//        labelList.add("保研");
//        labelList.add("工作");
//        labelList.add("校园");
//        bean.setSkillList(labelList);
//        skillBeanList.add(bean);
//
//        SkillBean bean2 = new SkillBean();
//        bean2.setCateId(1);
//        bean2.setSkillTotal("高校教师");
//        List<String> labelList2 = new ArrayList<>();
//        labelList2.add("理科");
//        labelList2.add("工科");
//        labelList2.add("文科");
//        labelList2.add("其他");
//        bean2.setSkillList(labelList2);
//        skillBeanList.add(bean2);
//
//
//        SkillBean bean3 = new SkillBean();
//        bean3.setCateId(2);
//        bean3.setSkillTotal("行业大牛");
//        List<String> labelList3 = new ArrayList<>();
//        labelList3.add("政治");
//        labelList3.add("IT");
//        labelList3.add("商业");
//        labelList3.add("教育");
//        bean3.setSkillList(labelList3);
//        skillBeanList.add(bean3);
//
//        SkillBean bean4 = new SkillBean();
//        bean4.setCateId(3);
//        bean4.setSkillTotal("公益人士");
//        List<String> labelList4 = new ArrayList<>();
//        labelList4.add("山区支教");
//        labelList4.add("关爱残疾");
//        labelList4.add("抗险救灾");
//        labelList4.add("跨国公益");
//        bean4.setSkillList(labelList4);
//        skillBeanList.add(bean4);
//        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
//        recyclerCatogory.setLayoutManager(manager);
//
//        recyclerCatogory.setAdapter(new CommonAdapter<SkillBean>(getActivity(), R.layout.item_recy_skill, skillBeanList) {
//
//            @Override
//            protected void convert(ViewHolder holder, final SkillBean skillBean, int position) {
//                holder.setText(R.id.tv_skill, skillBean.getSkillTotal());
//                GridView grid = holder.getView(R.id.grid_skill);
//                TextView title = holder.getView(R.id.tv_skill);
//                switch (skillBean.getCateId()) {
//                    case 0:
//                        title.setBackgroundColor(getResources().getColor(R.color.skill_color1));
//                        title.setText("优秀学生");
//                        break;
//                    case 1:
//                        title.setBackgroundColor(getResources().getColor(R.color.skill_color2));
//                        title.setText("高校教师");
//                        break;
//                    case 2:
//                        title.setBackgroundColor(getResources().getColor(R.color.skill_color3));
//                        title.setText("行业大牛");
//                        break;
//                    case 3:
//                        title.setBackgroundColor(getResources().getColor(R.color.skill_color4));
//                        break;
//                }
//                List<String> labelList = skillBean.getSkillList();
//                grid.setAdapter(new com.zhy.adapter.abslistview.CommonAdapter<String>(
//                        getActivity(), R.layout.item_grid_skill, labelList) {
//                    @Override
//                    protected void convert(com.zhy.adapter.abslistview.ViewHolder viewHolder, String item, int position) {
//                        viewHolder.setText(R.id.tv_skill, item);
//                        switch (skillBean.getCateId()) {
//                            case 0:
//                                viewHolder.setBackgroundColor(R.id.tv_skill,getResources().getColor(R.color.skill_color1));
//                                break;
//                            case 1:
//                                viewHolder.setBackgroundColor(R.id.tv_skill,getResources().getColor(R.color.skill_color2));
//                                break;
//                            case 2:
//                                viewHolder.setBackgroundColor(R.id.tv_skill,getResources().getColor(R.color.skill_color3));
//                                break;
//                            case 3:
//                                viewHolder.setBackgroundColor(R.id.tv_skill,getResources().getColor(R.color.skill_color4));
//                                break;
//                        }
//                    }
//                });
//            }
//        });


//        mLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
//        recyclerCatogory.setLayoutManager(mLayoutManager);
//        SkillRecyclerAdapter adapter = new SkillRecyclerAdapter(getActivity(),skillBeanList);
//        recyclerCatogory.setAdapter(adapter);
        return view;

    }
    String theme[] = {"期末","考研","保研","就业","留学","考证","专利","论文","竞赛","兼职"};
    String entheme[] = {"Terminal","PubMed","Postgraduate Recommendation","Obtain Employment","Overseas Study"
            ,"Examination Certificate","Patent","Paper","Pompetition","Part-time Job"};
    public void initData(){
        list_h = new ArrayList<HashMap<String,Object>>();
        list_v_man = new ArrayList<HashMap<String,Object>>();
        list_v_theme = new ArrayList<HashMap<String,Object>>();
        for(int i=0;i<theme.length;i++){
            HashMap<String,Object> map = new HashMap<>();
            map.put("title",theme[i]);
            map.put("entitle",entheme[i]);
            list_h.add(map);
        }
        HashMap<String,Object> map1 = new HashMap<>();
        map1.put("title","学霸");
        map1.put("content","保研东大学长指导你，保研不迷路");
        map1.put("theme","2千人关注/保研");
        list_v_man.add(map1);
        HashMap<String,Object> map2 = new HashMap<>();
        map2.put("title","主席学长");
        map2.put("content","校学生会主席教你如何不荒废大学四年");
        map2.put("theme","3千人关注/考研");
        list_v_man.add(map2);
        HashMap<String,Object> map3 = new HashMap<>();
        map3.put("title","英语大佬");
        map3.put("content","留学问题知多少，学姐教你如何保签");
        map3.put("theme","2.7千人关注/留学");
        list_v_man.add(map3);
        HashMap<String,Object> map4 = new HashMap<>();
        map4.put("title","动手达人");
        map4.put("content","十余项专利拥有者告诉你，并没有那么困难");
        map4.put("theme","2千人关注/保研");
        list_v_man.add(map4);
        HashMap<String,Object> map5 = new HashMap<>();
        map5.put("title","高薪就职");
        map5.put("content","阿里、腾讯、华为，只有你想不到的没有我们找不到的学长，来为你一一解惑");
        map5.put("theme","2千人关注/保研");
        list_v_theme.add(map5);
        HashMap<String,Object> map6 = new HashMap<>();
        map6.put("title","留学生活");
        map6.put("content","How can I do it?远在大洋彼岸的学长学姐说，so eazy");
        map6.put("theme","3千人关注/留学");
        list_v_theme.add(map6);
        HashMap<String,Object> map7 = new HashMap<>();
        map7.put("title","高数不难");
        map7.put("content","5位4.8绩点学长共同带你复习高数，你还觉得自己过不了吗？");
        map7.put("theme","2千人关注/期末");
        list_v_theme.add(map7);
        HashMap<String,Object> map8 = new HashMap<>();
        map8.put("title","竞赛交流");
        map8.put("content","多个国家级奖项获得团队聚在一起会发生什么奇妙的化学反应呢");
        map8.put("theme","2千人关注/保研");
        list_v_theme.add(map8);
    }
//    @OnClick(R.id.ciriv_user_icon)
//    public void openDrawer(){
//        MainActivity.drawer.openDrawer(Gravity.LEFT,true);
//    }
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        unbinder.unbind();
//    }
//    @OnClick({R.id.ll_search,R.id.iv_location})
//    public void onclick(View v){
//        switch (v.getId()){
//            case R.id.ll_search:
//                SearchFragment.TYPE = "SKILL";
//                Intent intent = new Intent(getActivity(), SearchFragment.class);
//                startActivity(intent);
//                break;
//            case R.id.iv_location:
//                Intent location = new Intent(getActivity(), LocationActivity.class);
//                startActivity(location);
//                break;
//        }
//    }
}
