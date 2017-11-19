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
import com.wangsheng.sharecampus.adapter.SkillRecyclerAdapter;
import com.wangsheng.sharecampus.fragment.RecycleFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CheckclassSkillActivity extends AppCompatActivity {
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.iv_back)
    ImageView back;
    public static int pagenum = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkclass_skill);
        ButterKnife.bind(this);
        String[] tabArr = new String[]{"期末","考研","保研","就业","留学","考证","专利","论文","竞赛","兼职"};
        List<Fragment> fragList = new ArrayList<>();
        for (int i = 0; i < tabArr.length; i++) {
            RecycleFragment recycleFragment = new RecycleFragment();
            recycleFragment.adapter = new SkillRecyclerAdapter(initData(),this).getAdapter();
            fragList.add(recycleFragment);
        }

        viewPager.setAdapter(new CategoryPageAdapter(getSupportFragmentManager(),fragList));
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabArr.length; i++) {
            tabLayout.getTabAt(i).setText(tabArr[i]);
        }
        viewPager.setCurrentItem(pagenum);
    }
    public  List<HashMap<String,Object>> initData(){
        List<HashMap<String,Object>> list_v_man = new ArrayList<>();
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
        return  list_v_man;
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
