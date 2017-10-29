package com.wangsheng.sharecampus.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.dialog.ChooseLimitDialog;
import com.wangsheng.sharecampus.dialog.ChoosePriceDialog;
import com.wangsheng.sharecampus.dialog.ChooseTimeDialog;
import com.wangsheng.sharecampus.view.IconTextView;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateTaskActivity extends AppCompatActivity{

    private static final int REQUEST_CODE_CHOOSE = 1001;
    @BindView(R.id.tfl_labels)
    TagFlowLayout tflLabels;
    @BindView(R.id.tv_choose_price)
    IconTextView pricetext;
    @BindView(R.id.grid_add_pic)
    GridView gridAddPic;
    @BindView(R.id.image_back)ImageView back;
    @BindView(R.id.tv_choose_people)
    IconTextView peopletext;
    @BindView(R.id.tv_choose_time)
    IconTextView timetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        ButterKnife.bind(this);
        List<String> labelList = new ArrayList<>();
        labelList.add("学习提问");
        labelList.add("生活提问");
        labelList.add("代取代购");
        labelList.add("失物招领");
        labelList.add("竞赛队友");
        labelList.add("考研研友");
        labelList.add("物品租借");
        labelList.add("物品维修");
        labelList.add("健身伙伴");
        labelList.add("摄影剪辑");
        labelList.add("修图海报");
        labelList.add("兼职同行");

        tflLabels.setAdapter(new TagAdapter<String>(labelList) {
            @Override
            public View getView(FlowLayout parent, int position, String label) {
                TextView view = (TextView) LayoutInflater.from(CreateTaskActivity.this)
                        .inflate(R.layout.layout_label, tflLabels, false);
                view.setText(label);
                return view;
            }
        });


        final List<Integer> res = new ArrayList<>();
        res.add(R.drawable.bg_add_picture);
        gridAddPic.setAdapter(new CommonAdapter<Integer>(this, R.layout.item_grid_picd, res) {
            @Override
            protected void convert(ViewHolder viewHolder, Integer item, int position) {
                viewHolder.setBackgroundRes(R.id.iv_pic, item);

                ImageView iv = viewHolder.getView(R.id.iv_pic);
                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pickPictures();
                    }
                });

            }
        });
    }

    private void pickPictures() {
        Matisse.from(this)
                .choose(MimeType.allOf())
                .countable(true)
                .maxSelectable(9)
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                .thumbnailScale(0.85f)
                .imageEngine(new GlideEngine())
                .theme(R.style.MyMatisseTheme)
                .forResult(REQUEST_CODE_CHOOSE);
    }

    @OnClick(R.id.tv_choose_price)
    public void onViewClicked() {
        ChoosePriceDialog dialog = new ChoosePriceDialog();
        dialog.show(getFragmentManager(), ChoosePriceDialog.TAG);
        dialog.setmClickListener(new ChoosePriceDialog.ClickListener() {
            @Override
            public void onChoosePrice(int price) {
                pricetext.setText(price+"金");
            }
        });
    }
    @OnClick(R.id.tv_choose_time)
    public void Choosetime(){
        ChooseTimeDialog dialog = new ChooseTimeDialog();
        dialog.show(getFragmentManager(), ChooseTimeDialog.TAG);
        dialog.setmClickListener(new ChooseTimeDialog.ClickListener() {

            @Override
            public void onChooseTime(int month, int date, int hour) {
                timetext.setText((month*30+date)+"天"+hour+"小时");
            }
        });
    }
    @OnClick(R.id.tv_choose_people)
    public  void Choosepeople(){
        ChooseLimitDialog dialog = new ChooseLimitDialog();
        dialog.show(getFragmentManager(), ChooseLimitDialog.TAG);
        dialog.setmClickListener(new ChooseLimitDialog.ClickListener() {

            @Override
            public void onChooseLimit(int num) {
                peopletext.setText(num+"人");
            }
        });
    }

    @OnClick(R.id.image_back)
    public void back(){
        CreateTaskActivity.this.finish();
    }
}
