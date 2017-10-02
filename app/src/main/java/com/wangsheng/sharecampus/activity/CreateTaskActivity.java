package com.wangsheng.sharecampus.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateTaskActivity extends AppCompatActivity {

    @BindView(R.id.tfl_labels)
    TagFlowLayout tflLabels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        ButterKnife.bind(this);

        List<String> labelList = new ArrayList<>();
        labelList.add("失物招领");
        labelList.add("勾搭");
        labelList.add("代课");

        tflLabels.setAdapter(new TagAdapter<String>(labelList) {
            @Override
            public View getView(FlowLayout parent, int position, String label) {
                TextView view = (TextView) LayoutInflater.from(CreateTaskActivity.this)
                        .inflate(R.layout.layout_label,tflLabels,false);
                view.setText(label);
                return view;
            }
        });
    }
}
