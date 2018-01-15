package com.wangsheng.sharecampus.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.wangsheng.sharecampus.ApiService.UserService;
import com.wangsheng.sharecampus.ApiServiceBean.UserServiceRequset.UserInfoRequset;
import com.wangsheng.sharecampus.ApiServiceBean.UserServiceResponse.UserInfoResponse;
import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.bean.ResponseInfo;
import com.wangsheng.sharecampus.dialog.ShareDialog;
import com.wangsheng.sharecampus.util.HttpManager;
import com.wangsheng.sharecampus.util.HttpObserver;
import com.wangsheng.sharecampus.util.RxSchedulersHelper;
import com.wangsheng.sharecampus.util.SharedUtil;
import com.wangsheng.sharecampus.view.IconTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;

public class AboutMeActivity extends AppCompatActivity {

    @BindView(R.id.imageview)
    ImageView ivMyBg;
    @BindView(R.id.toolbar_back)
    ImageView toolbarBack;
    @BindView(R.id.toolbar_user_name)
    TextView toolbarUserName;
    @BindView(R.id.toolbar_share)
    ImageView toolbarShare;
    @BindView(R.id.btn_edit_my_info)
    Button btnEditMyInfo;
    @BindView(R.id.user_address)
    TextView user_address;
    @BindView(R.id.user_age)
    TextView user_age;
    @BindView(R.id.user_gender)
    TextView user_gender;
    @BindView(R.id.user_id)
    TextView uset_id;
    @BindView(R.id.user_introduce)
    TextView user_introduce;
    @BindView(R.id.user_realname)
    TextView user_realname;
    @BindView(R.id.tv_user_name)
    IconTextView user_nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        ButterKnife.bind(this);

        Glide.with(this)
                .load(R.drawable.guilty_crown)
                .into(ivMyBg);
        getInfo(SharedUtil.getParam("userName","").toString());
    }

    @OnClick({R.id.toolbar_back, R.id.toolbar_share})
    public void toolbarClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_back:
                finish();
                break;
            case R.id.toolbar_share:

                ShareDialog dialog = new ShareDialog();
                dialog.show(getSupportFragmentManager(), ShareDialog.TAG);
                break;
        }
    }

    @OnClick(R.id.btn_edit_my_info)
    public void editMyInfo() {
        Intent intent = new Intent(this,EditInfoActivity.class);
        startActivity(intent);
    }
    public void getInfo(final String userName){
        UserService userService = HttpManager.getInstance().createService(UserService.class);
        UserInfoRequset infobean = new UserInfoRequset();
        infobean.setUserName(userName);
        Observable<ResponseInfo<JsonObject>> call = userService.info(infobean);
        call.compose(RxSchedulersHelper.<ResponseInfo<JsonObject>>io_main())
                .subscribe(new HttpObserver<JsonObject>() {
                    @Override
                    public void onSuccess(JsonObject user) {
                        Gson gson = new Gson();
                        UserInfoResponse info = gson.fromJson(user.getAsJsonObject("user"), UserInfoResponse.class);
                        uset_id.setText("ID："+info.getUserId());
                        if(info.getGender()==1){
                            user_gender.setText("性别：男");
                        }else if(info.getGender()==2){
                            user_gender.setText("性别：女");
                        }else {
                            user_gender.setText("性别：未知");
                        }
                        if(info.getRealname()!=null&&info.getRealname().length()!=0){
                            user_realname.setText("真实姓名："+info.getRealname());
                            SharedUtil.saveParam("userRealname",info.getRealname());
                        }else{
                            user_realname.setText("真实姓名：未知");
                        }
                        if(info.getPhone()!=null&&info.getPhone().length()!=0){
                            user_nickname.setText(info.getPhone());
                            SharedUtil.saveParam("usernickName",info.getPhone());
                        }else{
                            SharedUtil.saveParam("usernickName",info.getUserName());
                            user_nickname.setText("暂无昵称");
                        }
                        if(info.getInfo()!=null&&info.getInfo().length()!=0){
                            user_introduce.setText(info.getInfo());
                            SharedUtil.saveParam("userIntroduce",info.getInfo());
                        }else{
                            user_introduce.setText("暂无介绍");
                        }

                    }
                    @Override
                    public void onFailed(String message) {
                        Toast.makeText(AboutMeActivity.this,message,Toast.LENGTH_SHORT).show();
                    }
                });
    }
    public AboutMeActivity() {
        aboutMeActivity = this;
    }

    public static AboutMeActivity getMainActivity() {
        return aboutMeActivity;
    }

    private static AboutMeActivity aboutMeActivity;

}
