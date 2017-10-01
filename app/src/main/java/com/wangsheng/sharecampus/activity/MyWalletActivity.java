package com.wangsheng.sharecampus.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.wangsheng.sharecampus.Bean.Business;
import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.adapter.BusinessAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by windows8 on 2017/10/1.
 */

public class MyWalletActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.iv_back)ImageView back;
    @BindView(R.id.iv_recycle)RecyclerView recyclerView;
    List<Business> list = new ArrayList<Business>();
    GridLayoutManager gridLayoutManager;
    BusinessAdapter businessAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);
        ButterKnife.bind(this);
        back.setOnClickListener(this);
        gridLayoutManager=new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);//设置为一个1列的纵向网格布局
        recyclerView.setLayoutManager(gridLayoutManager);
        Business b1 = new Business();
        b1.setBusinessSend("云一逸");
        b1.setBusinessType("买房");
        Business b2 = new Business();
        b2.setBusinessSend("云二逸");
        b2.setBusinessType("买房");
        Business b3 = new Business();
        b3.setBusinessSend("云三逸");
        b3.setBusinessType("买车");
        Business b4 = new Business();
        b4.setBusinessSend("云四逸");
        b4.setBusinessType("买楼");
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
        businessAdapter = new BusinessAdapter(this,list);
        recyclerView.setAdapter(businessAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                this.finish();
                break;
        }
    }
}
