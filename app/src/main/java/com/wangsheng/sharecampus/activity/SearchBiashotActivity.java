package com.wangsheng.sharecampus.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchBiashotActivity extends AppCompatActivity {
    @BindView(R.id.iv_cancel)
    TextView cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_biashot);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.iv_cancel})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.iv_cancel:
                finish();
                break;
        }
    }

}
