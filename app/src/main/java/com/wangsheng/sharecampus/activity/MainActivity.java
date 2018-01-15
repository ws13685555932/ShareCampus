package com.wangsheng.sharecampus.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.dialog.LoginDialog;
import com.wangsheng.sharecampus.dialog.PickSexDialog;
import com.wangsheng.sharecampus.fragment.BigshotMainFragment;
import com.wangsheng.sharecampus.fragment.TaskMainFragment;
import com.wangsheng.sharecampus.util.SharedUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public static DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.ll_b1)
    LinearLayout llb1;
    @BindView(R.id.b1_image)
    ImageView b1image;
    @BindView(R.id.b1_text)
    TextView b1text;
    @BindView(R.id.ll_b2)
    LinearLayout llb2;
    @BindView(R.id.b2_image)
    ImageView b2image;
    @BindView(R.id.ll_b3)
    LinearLayout llb3;
    @BindView(R.id.b3_image)
    ImageView b3image;
    @BindView(R.id.b3_text)
    TextView b3text;

    Fragment bigshot;
    Fragment task;
    private LinearLayout islogin,notlogin;
    private TextView user_name,user_introduce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.black_primary));
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        navigationView.setNavigationItemSelectedListener(this);

        drawer.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                Log.d("tag", "onDrawerSlide: " + slideOffset);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(Color.TRANSPARENT);
                    getWindow().getDecorView().setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                }

            }
        });

        bigshot = new BigshotMainFragment();
        task = new TaskMainFragment();

        addFragment(R.id.content_layout, bigshot);
        addFragment(R.id.content_layout, task);

        int[][] states = new int[][]{
                new int[]{-android.R.attr.state_checked},
                new int[]{android.R.attr.state_checked}
        };

        int[] colors = new int[]{getResources().getColor(R.color.white),
                getResources().getColor(R.color.blue_light)
        };
        ColorStateList csl = new ColorStateList(states, colors);

        View header = navigationView.getHeaderView(0);
        CircleImageView ivUserIconNav = (CircleImageView) header.findViewById(R.id.civ_user_icon);
        ivUserIconNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutMeActivity.class);
                startActivity(intent);
            }
        });
        islogin = (LinearLayout)header.findViewById(R.id.drawer_islogin);
        notlogin = (LinearLayout)header.findViewById(R.id.drawer_notlogin);
        user_name = (TextView)header.findViewById(R.id.user_name);
        user_introduce = (TextView)header.findViewById(R.id.user_introduce);
        CircleImageView login = (CircleImageView) header.findViewById(R.id.drawer_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginDialog dialog = new LoginDialog();
                dialog.show(getSupportFragmentManager(), PickSexDialog.TAG);
            }
        });
        refreshLogin();
        changePage(1);
    }
    public void refreshLogin(){
        if(SharedUtil.getParam("islogin","").toString().equals("1")){
            user_name.setText(SharedUtil.getParam("usernickName","暂无昵称").toString());
            user_introduce.setText(SharedUtil.getParam("userIntroduce","暂无介绍").toString());
            islogin.setVisibility(View.VISIBLE);
            notlogin.setVisibility(View.GONE);
        }else {
            notlogin.setVisibility(View.VISIBLE);
            islogin.setVisibility(View.GONE);
        }
    }
    public MainActivity() {
        mainActivity = this;
    }

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static MainActivity mainActivity;

    private void showFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.show(fragment);
        transaction.commit();
    }

    private void hideFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.hide(fragment);
        transaction.commit();
    }

    private void addFragment(int layout, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(layout,fragment);
        transaction.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_invite:
                Intent invite = new Intent(MainActivity.this, InviteActivity.class);
                startActivity(invite);
                break;
            case R.id.nav_taskout:
                Intent taskout = new Intent(MainActivity.this, TaskOutActivity.class);
                startActivity(taskout);
                break;
            case R.id.nav_taskin:
                Intent taskin = new Intent(MainActivity.this, TaskInActivity.class);
                startActivity(taskin);
                break;
            case R.id.nav_wallet:
                Intent wallet = new Intent(MainActivity.this, MyWalletActivity.class);
                startActivity(wallet);
                break;
            case R.id.nav_sincerity:
                Intent sincerity = new Intent(MainActivity.this, MySincerityActivity.class);
                startActivity(sincerity);
                break;
            case R.id.nav_message:
                Intent message = new Intent(MainActivity.this, MessageActivity.class);
                startActivity(message);
                break;
            case R.id.nav_concern:
                Intent concern = new Intent(MainActivity.this, MyConcernActivity.class);
                startActivity(concern);
                break;
            case R.id.nav_collection:
                Intent collection = new Intent(MainActivity.this, MyCollectionActivity.class);
                startActivity(collection);
                break;
            case R.id.nav_setting:
                Intent setting = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(setting);
                break;
        }

        return false;
    }
    public void changePage(int pageNum){
        switch (pageNum){
            case 1:
                showFragment(bigshot);
                hideFragment(task);
                b1image.setImageDrawable(tintDrawable(R.drawable.bottom_item_bigshot,R.color.blue_light));
                b1text.setTextColor(getResources().getColor(R.color.blue_light));
                b3image.setImageDrawable(tintDrawable(R.drawable.bottom_item_task,R.color.white));
                b3text.setTextColor(getResources().getColor(R.color.white));
                break;
            case 2:
                Intent intent = new Intent(MainActivity.this,CreateTaskActivity.class);
                startActivity(intent);
                break;
            case 3:
                showFragment(task);
                hideFragment(bigshot);
                b1image.setImageDrawable(tintDrawable(R.drawable.bottom_item_bigshot,R.color.white));
                b1text.setTextColor(getResources().getColor(R.color.white));
                b3image.setImageDrawable(tintDrawable(R.drawable.bottom_item_task,R.color.blue_light));
                b3text.setTextColor(getResources().getColor(R.color.blue_light));
                break;
        }
    }
    public static Drawable tintDrawable(int image, int color) {
        Drawable drawable = getMainActivity().getResources().getDrawable(image).mutate();
        drawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawable, getMainActivity().getResources().getColor(color));
        return drawable;
    }
    @OnClick({R.id.ll_b1,R.id.ll_b2,R.id.ll_b3})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.ll_b1:
                changePage(1);
                break;
            case R.id.ll_b2:
                changePage(2);
                break;
            case R.id.ll_b3:
                changePage(3);
                break;
        }
    }
}
