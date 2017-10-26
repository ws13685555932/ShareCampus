package com.wangsheng.sharecampus.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.view.DividerItemDecoration;
import com.wangsheng.sharecampus.view.MyLinearLayoutManager;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.wangsheng.sharecampus.MyApplication.getContext;

/**
 * Created by wangsheng
 * on 2017/9/27.
 * <p>
 * 首页消息界面
 */

public class MessageActivity extends AppCompatActivity {

    @BindView(R.id.recycler_chat)
    RecyclerView recyclerChat;
    @BindView(R.id.message_back)
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        List<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
        HashMap<String,String> map1 = new HashMap<String,String>();
        map1.put("messageusericon",R.drawable.image_head1+"");
        map1.put("messagecontent","在做什么呢");
        map1.put("messageusername","李逸云");
        map1.put("messagetime","12:20");
        map1.put("messageunread","5");
        list.add(map1);
        HashMap<String,String> map2 = new HashMap<String,String>();
        map2.put("messageusericon",R.drawable.image_head2+"");
        map2.put("messagecontent","昨天晚上你咋跑了？？？？");
        map2.put("messageusername","彭小野");
        map2.put("messagetime","8:30");
        map2.put("messageunread","2");
        list.add(map2);HashMap<String,String> map3 = new HashMap<String,String>();
        map3.put("messageusericon",R.drawable.image_head3+"");
        map3.put("messagecontent","这么晚了你还不睡，厉害！");
        map3.put("messageusername","陈彦儒");
        map3.put("messagetime","02:26");
        map3.put("messageunread","1");
        list.add(map3);
        recyclerChat.setAdapter(new CommonAdapter<HashMap<String,String>>(getContext(),R.layout.item_recy_chat,list) {
            @Override
            protected void convert(ViewHolder holder, HashMap<String,String> o, int position) {
                ((CircleImageView)holder.getView(R.id.message_image_usericon)).setImageResource(Integer.parseInt(o.get("messageusericon")));
                ((TextView)holder.getView(R.id.message_text_content)).setText(o.get("messagecontent"));
                ((TextView)holder.getView(R.id.message_text_username)).setText(o.get("messageusername"));
                ((TextView)holder.getView(R.id.message_text_time)).setText(o.get("messagetime"));
                ((TextView)holder.getView(R.id.message_text_unread)).setText(o.get("messageunread"));
            }
        });

        MyLinearLayoutManager layoutManager = new MyLinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerChat.setLayoutManager(layoutManager);
        recyclerChat.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL_LIST));
    }
    @OnClick({R.id.message_back})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.message_back:
                finish();
                break;
        }
    }
}
