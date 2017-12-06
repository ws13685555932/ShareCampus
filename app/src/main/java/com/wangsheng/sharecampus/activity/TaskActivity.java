package com.wangsheng.sharecampus.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.fragment.task.getTaskBean;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TaskActivity extends AppCompatActivity{

    @BindView(R.id.recycler_leave_message)
    RecyclerView recyclerLeaveMessage;
    @BindView(R.id.nsv_parent)
    NestedScrollView nsvParent;
    @BindView(R.id.btn_accept)
    Button btnAccept;
    @BindView(R.id.grid_pics)
    GridView gridPics;
    @BindView(R.id.task_title)TextView title;
    @BindView(R.id.task_content)TextView content;
    @BindView(R.id.task_price)TextView price;
    @BindView(R.id.task_user_name)TextView name;
    @BindView(R.id.back)ImageView back;
    @BindView(R.id.task_time)TextView time;
    @BindView(R.id.task_bottom_tool)
    RelativeLayout bottomtool;
    @BindView(R.id.task_bottom_reply)
    RelativeLayout bottomreply;
    @BindView(R.id.image_task_reply)
    ImageView reply;
    @BindView(R.id.task_edit_reply)
    EditText editreply;
    @BindView(R.id.rl_task)
    RelativeLayout rltask;
    @BindView(R.id.text_reply_num)
    TextView replynum;
    public static getTaskBean task;
    private ArrayList<HashMap<String,String>> list;
    private CommonAdapter commonAdapter;
    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        ButterKnife.bind(this);

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
       list = new ArrayList<HashMap<String,String>>();
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("username","萧炎");
        map.put("messagetime","昨天");
        map.put("messagecontent","我明天没有空啊，后天可不可以啊");
        list.add(map);
        list.add(map);
        commonAdapter = new CommonAdapter<HashMap<String,String>>(this, R.layout.item_recy_leave_message, list) {
            @Override
            protected void convert(ViewHolder holder, HashMap<String,String> o, int position) {
                ((TextView)holder.getView(R.id.text_message_buildnum)).setText("#"+(position+1));
                ((TextView)holder.getView(R.id.text_message_content)).setText(o.get("messagecontent"));
                ((TextView)holder.getView(R.id.text_message_time)).setText(o.get("messagetime"));
                ((TextView)holder.getView(R.id.text_message_user_name)).setText(o.get("username"));
            }
        };
        recyclerLeaveMessage.setAdapter(commonAdapter);
        replynum.setText("留言("+list.size()+")");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerLeaveMessage.setLayoutManager(layoutManager);

        recyclerLeaveMessage.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(0, 0, 0, 1);
            }

        });

        recyclerLeaveMessage.setFocusable(false);

        List<Integer> resIds = new ArrayList<>();
        resIds.add(R.drawable.image_head5);
        resIds.add(R.drawable.image_head5);
        resIds.add(R.drawable.image_head5);
        resIds.add(R.drawable.image_head5);
        gridPics.setAdapter(new com.zhy.adapter.abslistview.CommonAdapter<Integer>(this,R.layout.item_grid_picd,resIds) {
            @Override
            protected void convert(com.zhy.adapter.abslistview.ViewHolder viewHolder, Integer item, int position) {

            }
        });
        title.setText(task.getTitle());
        content.setText(task.getDescription());
        price.setText("悬赏金额：￥"+task.getPrice());
        if(task.getPublisherName() == null){
            name.setText(task.getPublisherId());
        }else name.setText(task.getPublisherId());
        time.setText("发布于2016年10月15日 "+task.getPuttime());
        editreply.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if((i == EditorInfo.IME_ACTION_SEND)&(textView.getText().toString().length()!=0)){
                    HashMap<String,String> map = new HashMap<String,String>();
                    map.put("username","陌上疏影凉");
                    map.put("messagetime","刚刚");
                    map.put("messagecontent",editreply.getText().toString());
                    list.add(map);
                    commonAdapter.notifyDataSetChanged();
                    replynum.setText("留言("+list.size()+")");
                    if (imm != null) {
                        imm.hideSoftInputFromWindow(editreply.getWindowToken(), 0);
                    }
                    bottomreply.setVisibility(View.GONE);
                    bottomtool.setVisibility(View.VISIBLE);
                    return true;
                }

                return false;
            }
        });
    }

    @OnClick(R.id.btn_accept)
    public void onViewClicked() {
        Intent intent = new Intent(this, TaskAcceptActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.back,R.id.image_task_reply,R.id.rl_task})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                TaskActivity.this.finish();
                break;
            case R.id.image_task_reply:
                bottomreply.setVisibility(View.VISIBLE);
                bottomtool.setVisibility(View.GONE);
                editreply.setFocusable(true);
                editreply.setFocusableInTouchMode(true);
                getWindow().getDecorView().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (imm != null) {
                            editreply.requestFocus();
                            imm.showSoftInput(editreply, 0);
                        }
                    }
                }, 100);
                break;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }

                bottomreply.setVisibility(View.GONE);
                bottomtool.setVisibility(View.VISIBLE);
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }
    public  boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = { 0, 0 };
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

}
