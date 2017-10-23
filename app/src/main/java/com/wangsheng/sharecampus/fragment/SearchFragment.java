package com.wangsheng.sharecampus.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SearchFragment extends Fragment {

    @BindView(R.id.grid_label)
    GridView gridlabel;
    public static String TYPE = "SKILL";
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
        gridlabel.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return labelBean.size();
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }
            class ViewHolder{
                TextView labeltitle;
            }
            @Override
            public View getView(int i, View convertView, ViewGroup viewGroup) {
                ViewHolder viewHolder;
                //不是第一个item的话就重写item
                if (convertView == null) {
                    viewHolder = new ViewHolder();
                    //获取item.xml文件
                    convertView = LayoutInflater.from(getActivity()).inflate(R.layout.item_grid_label, null);
                    //获取item中的控件
                    viewHolder.labeltitle = (TextView) convertView.findViewById(R.id.tv_label);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                viewHolder.labeltitle.setText(labelBean.get(i));
                return convertView;
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
