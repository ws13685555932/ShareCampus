package com.wangsheng.sharecampus.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity {
    @BindView(R.id.iv_cancel)
    TextView ivcancel;
    @BindView(R.id.image_search)
    ImageView imagesearch;
    @BindView(R.id.edit_search)
    EditText editsearch;
    @BindView(R.id.image_cancel)
    ImageView imagecancel;
    @BindView(R.id.grid_label)
    GridView gridlabel;
    public static String TYPE = "SKILL";
    List<String> labelBean = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
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
                    convertView = LayoutInflater.from(SearchActivity.this).inflate(R.layout.item_grid_label, null);
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
        editsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                imagecancel.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        imagecancel.setVisibility(View.GONE);
    }
    public void setSkillView(){
        editsearch.setHint("搜索大V姓名");
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
        editsearch.setHint("搜索任务关键词");
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
    @OnClick({R.id.image_cancel,R.id.iv_cancel})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.image_cancel:
                editsearch.setText("");
                imagecancel.setVisibility(View.GONE);
                break;
            case R.id.iv_cancel:
                finish();
                break;
        }
    }
}
