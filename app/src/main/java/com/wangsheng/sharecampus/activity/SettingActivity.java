package com.wangsheng.sharecampus.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.util.SharedUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends AppCompatActivity {
    @BindView(R.id.btn_exit)
    Button btnexit;
    @BindView(R.id.toolbar_back)
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.btn_exit,R.id.toolbar_back})
    public void onclick(View v){
        switch (v.getId()){
            case R.id.btn_exit:

                new AlertDialog.Builder(this)
                        .setTitle("退出登录")
                        .setMessage("确定退出登录吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                SharedUtil.saveParam("islogin","0");
                                SharedUtil.saveParam("userPass","");
                                MainActivity.getMainActivity().refreshLogin();
                                finish();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
                break;
            case R.id.toolbar_back:
                finish();
                break;
        }
    }
}
