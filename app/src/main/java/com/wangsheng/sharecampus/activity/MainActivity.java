package com.wangsheng.sharecampus.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.dialog.LoginDialog;
import com.wangsheng.sharecampus.dialog.PickSexDialog;
import com.wangsheng.sharecampus.fragment.SkillMainFragment;
import com.wangsheng.sharecampus.fragment.TaskMainFragment;
import com.wangsheng.sharecampus.util.SharedUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public static DrawerLayout drawer;
    @BindView(R.id.bottom_nav)
    BottomNavigationView bottomNav;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    Fragment skill;
    Fragment task;
    public static LinearLayout islogin,notlogin;
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

        skill = new SkillMainFragment();
        task = new TaskMainFragment();

        addFragment(R.id.content_layout, skill);
        addFragment(R.id.content_layout, task);

        hideFragment(task);

        int[][] states = new int[][]{
                new int[]{-android.R.attr.state_checked},
                new int[]{android.R.attr.state_checked}
        };

        int[] colors = new int[]{getResources().getColor(R.color.white),
                getResources().getColor(R.color.blue_light)
        };
        ColorStateList csl = new ColorStateList(states, colors);
        bottomNav.setItemTextColor(csl);
        bottomNav.setItemIconTintList(csl);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.task:
                        hideFragment(task);
                        showFragment(skill);
                        break;
                    case R.id.message:
                        hideFragment(skill);
                        showFragment(task);
                        break;
                    case R.id.add_task:
                        Intent intent = new Intent(MainActivity.this,CreateTaskActivity.class);
                        startActivity(intent);
                }
                return true;
            }
        });


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
        CircleImageView login = (CircleImageView) header.findViewById(R.id.drawer_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginDialog dialog = new LoginDialog();
                dialog.show(getSupportFragmentManager(), PickSexDialog.TAG);
            }
        });
        refreshLogin();
    }
    public void refreshLogin(){
        if(SharedUtil.getParam("islogin","").toString().equals("1")){
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
}
