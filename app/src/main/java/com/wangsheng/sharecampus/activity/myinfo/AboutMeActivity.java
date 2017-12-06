package com.wangsheng.sharecampus.activity.myinfo;

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
import com.wangsheng.sharecampus.ApiService.UserService;
import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.activity.editinfo.EditInfoActivity;
import com.wangsheng.sharecampus.bean.ResponseInfo;
import com.wangsheng.sharecampus.dialog.ShareDialog;
import com.wangsheng.sharecampus.util.HttpManager;
import com.wangsheng.sharecampus.util.HttpObserver;
import com.wangsheng.sharecampus.util.RxSchedulersHelper;
import com.wangsheng.sharecampus.util.SharedUtil;

import org.json.JSONException;
import org.json.JSONObject;

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
    private void getInfo(final String userName){
        UserService userService = HttpManager.getInstance().createService(UserService.class);
        infoBean infobean = new infoBean();
        infobean.setUserName(userName);
        Observable<ResponseInfo<Object>> call = userService.info(infobean);
        call.compose(RxSchedulersHelper.<ResponseInfo<Object>>io_main())
                .subscribe(new HttpObserver() {
                    @Override
                    public void onSuccess(Object user) {
                        try {
                            JSONObject jsonObject = new JSONObject(user.toString()).getJSONObject("user");
                            uset_id.setText("ID："+jsonObject.getInt("userId"));
                            if(jsonObject.getInt("gender")==1){
                                user_gender.setText("性别：男");
                            }else{
                                user_gender.setText("性别：女");
                            }
                            user_realname.setText("真实姓名："+jsonObject.getString("realname"));
                            user_introduce.setText(jsonObject.getString("info"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onFailed(String message) {
                        Toast.makeText(AboutMeActivity.this,message,Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
