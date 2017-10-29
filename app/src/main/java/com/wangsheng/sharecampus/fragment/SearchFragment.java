package com.wangsheng.sharecampus.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SearchFragment extends Fragment {

    @BindView(R.id.tfl_labels)
    TagFlowLayout tflLabels;
    public String TYPE = "SKILL";
    List<String> labelBean = new ArrayList<String>();
    Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        unbinder = ButterKnife.bind(this, view);
        if(TYPE.equals("SKILL")){
            setSkillView();
        }
        else setTaskView();

        tflLabels.setAdapter(new TagAdapter<String>(labelBean) {
            @Override
            public View getView(FlowLayout parent, int position, String label) {
                TextView view = (TextView) LayoutInflater.from(getActivity())
                        .inflate(R.layout.layout_label, tflLabels, false);
                view.setText(label);
                return view;
            }
        });

        return view;
    }
    public void setSkillView(){
        labelBean.add("考研");
        labelBean.add("保研");
        labelBean.add("工作");
        labelBean.add("校园");
        labelBean.add("理科");
        labelBean.add("工科");
        labelBean.add("文科");
        labelBean.add("其他");
        labelBean.add("政治");
        labelBean.add("IT");
        labelBean.add("商业");
        labelBean.add("教育");
        labelBean.add("山区支教");
        labelBean.add("关爱残疾");
        labelBean.add("抗险救灾");
        labelBean.add("跨国公益");
    }
    public void setTaskView(){
        labelBean.add("学习提问");
        labelBean.add("生活提问");
        labelBean.add("代取代购");
        labelBean.add("失物招领");
        labelBean.add("竞赛队友");
        labelBean.add("考研研友");
        labelBean.add("物品租借");
        labelBean.add("物品维修");
        labelBean.add("健身伙伴");
        labelBean.add("摄影剪辑");
        labelBean.add("修图海报");
        labelBean.add("兼职同行");

    }
}
