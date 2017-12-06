package com.wangsheng.sharecampus.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.wangsheng.sharecampus.R;

import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BigshotActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    @BindView(R.id.iv_back)
    ImageView back;
    @BindView(R.id.iv_more)
    ImageView more;
    @BindView(R.id.iv_follow)
    ImageView follow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bigshot);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.iv_back,R.id.iv_more,R.id.iv_follow})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.iv_follow:
                if(v.getTag()==null||v.getTag().equals("1")){
                    ((ImageView)v).setImageResource(R.drawable.ic_nolike);
                    v.setTag("0");
                }else{
                    ((ImageView)v).setImageResource(R.drawable.ic_like);
                    v.setTag("1");
                }
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_more:
                PopupMenu popup = new PopupMenu(this, v);//第二个参数是绑定的那个view
                //获取菜单填充器
                MenuInflater inflater = popup.getMenuInflater();
                //填充菜单
                inflater.inflate(R.menu.bigshot_menu, popup.getMenu());
                //绑定菜单项的点击事件
                popup.setOnMenuItemClickListener(this);
                //使用反射，强制显示菜单图标
                try {
                    Field field = popup.getClass().getDeclaredField("mPopup");
                    field.setAccessible(true);
                    MenuPopupHelper mHelper = (MenuPopupHelper) field.get(popup);
                    mHelper.setForceShowIcon(true);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                popup.show();
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}
