package com.wangsheng.sharecampus.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.adapter.CategoryPageAdapter;
import com.wangsheng.sharecampus.fragment.RecycleFragment;
import com.wangsheng.sharecampus.util.ShowUtil;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CheckclassbigshotActivity extends AppCompatActivity {
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.iv_back)
    ImageView back;
    public static int pagenum = 1;
    int[] image = {R.drawable.image_head1,R.drawable.image_head2,R.drawable.image_head3,R.drawable.image_head4,R.drawable.image_head5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkclass_bigshot);
        ButterKnife.bind(this);
        String[] tabArr = new String[]{"期末","考研","保研","就业","留学","考证","专利","论文","竞赛","兼职"};
        List<Fragment> fragList = new ArrayList<>();
        for (int i = 0; i < tabArr.length; i++) {
            RecycleFragment recycleFragment = new RecycleFragment();
            CommonAdapter commonAdapter = new CommonAdapter<HashMap<String,Object>>(this, R.layout.item_recy_bigshot_detialed,initData()) {
                @Override
                protected void convert(ViewHolder holder, HashMap<String,Object> o, final int position) {
                    ((TextView)holder.getView(R.id.title)).setText(o.get("title").toString());
                    ((ImageView)holder.getView(R.id.imagehead)).setImageResource(image[position]);
                    holder.setOnClickListener(R.id.add,new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ShowUtil.print("点击了"+position);
                            if(view.getTag()!=null&&view.getTag().equals(1)){
                                view.setTag(0);
                                ((ImageView)view).setImageResource(R.drawable.ic_add_blue);
                                ShowUtil.toast("取消关注");
                            }else{
                                view.setTag(1);
                                ((ImageView)view).setImageResource(R.drawable.ic_true);
                                ShowUtil.toast("关注成功");
                            }
                        }
                    });
                    holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(mContext, BigshotActivity.class);
                            mContext.startActivity(intent);
                        }
                    });
                }
            };
            recycleFragment.adapter = commonAdapter;
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
    @OnClick({R.id.iv_back,R.id.checkclass_bigshot_search})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.checkclass_bigshot_search:
                Intent intent = new Intent(this,SearchBiashotActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }

}
