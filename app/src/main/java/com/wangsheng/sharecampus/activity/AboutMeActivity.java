package com.wangsheng.sharecampus.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wangsheng.sharecampus.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutMeActivity extends AppCompatActivity {

    @BindView(R.id.iv_my_bg)
    ImageView ivMyBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        ButterKnife.bind(this);

        Glide.with(this)
                .load(R.drawable.magic_girl)
                .into(ivMyBg);
    }
}
