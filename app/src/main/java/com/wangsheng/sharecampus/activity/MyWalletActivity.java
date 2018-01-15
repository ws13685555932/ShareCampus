package com.wangsheng.sharecampus.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.wangsheng.sharecampus.bean.Business;
import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.adapter.BusinessAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by windows8 on 2017/10/1.
 */

public class MyWalletActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.iv_back)
    ImageView back;
    @BindView(R.id.iv_recycle)
    RecyclerView recyclerView;
    List<Business> list = new ArrayList<Business>();
    LinearLayoutManager mLayoutManager;
    BusinessAdapter businessAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);
        ButterKnife.bind(this);
        back.setOnClickListener(this);

        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);//设置为一个1列的纵向网格布局
        recyclerView.setLayoutManager(mLayoutManager);

        Business b1 = new Business();
        b1.setBusinessSend("煎饼店");
        b1.setBusinessType("在线支付");
        b1.setBusinessMoney("-8.00");
        Business b2 = new Business();
        b2.setBusinessSend("移动营业厅");
        b2.setBusinessType("话费");
        b2.setBusinessMoney("-100.00");
        Business b3 = new Business();
        b3.setBusinessSend("李逸云");
        b3.setBusinessType("转账");
        b3.setBusinessMoney("-25.00");
        Business b4 = new Business();
        b4.setBusinessSend("妈妈");
        b4.setBusinessType("转账");
        b4.setBusinessMoney("+1500.00");
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
        businessAdapter = new BusinessAdapter(this, list);
        recyclerView.setAdapter(businessAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
        }
    }
}
