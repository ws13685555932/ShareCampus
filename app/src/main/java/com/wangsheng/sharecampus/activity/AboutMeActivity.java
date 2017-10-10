package com.wangsheng.sharecampus.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wangsheng.sharecampus.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutMeActivity extends AppCompatActivity {

    @BindView(R.id.imageview)
    ImageView ivMyBg;
    @BindView(R.id.toolbar_back)
    ImageView toolbarBack;
    @BindView(R.id.toolbar_user_name)
    TextView toolbarUserName;
    @BindView(R.id.toolbar_share)
    ImageView toolbarShare;
    @BindView(R.id.btn_edit_my_info)
    Button btnEditMyInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        ButterKnife.bind(this);

        Glide.with(this)
                .load(R.drawable.guilty_crown)
                .into(ivMyBg);

    }

    @OnClick({R.id.toolbar_back, R.id.toolbar_share})
    public void toolbarClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_back:
                break;
            case R.id.toolbar_share:
                break;
        }
    }

    @OnClick(R.id.btn_edit_my_info)
    public void editMyInfo() {
        Intent intent = new Intent(this,EditInfoActivity.class);
        startActivity(intent);
    }
}
