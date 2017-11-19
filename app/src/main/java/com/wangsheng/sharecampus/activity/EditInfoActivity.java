package com.wangsheng.sharecampus.activity;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lljjcoder.citypickerview.widget.CityPicker;
import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.dialog.PickSexDialog;
import com.wangsheng.sharecampus.dialog.WriteDialog;
import com.wangsheng.sharecampus.util.ShowUtil;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class EditInfoActivity extends AppCompatActivity{

    @BindView(R.id.rl_pick_sex)
    RelativeLayout rlPickSex;
    @BindView(R.id.rl_cityselector)
    RelativeLayout rlcity;
    @BindView(R.id.rl_birthday)
    RelativeLayout rlBirthday;
    @BindView(R.id.toolbar_back)
    ImageView toolbarBack;
    @BindView(R.id.text_birth)
    TextView birth;
    @BindView(R.id.text_sex)
    TextView user_sex;
    @BindView(R.id.rl_name)
    RelativeLayout rlname;
    @BindView(R.id.text_name)
    TextView user_name;
    @BindView(R.id.rl_school)
    RelativeLayout rlschool;
    @BindView(R.id.text_school)
    TextView user_school;
    @BindView(R.id.rl_introduction)
    RelativeLayout rlintroduction;
    @BindView(R.id.text_introduction)
    TextView user_introduction;
    @BindView(R.id.rl_realname)
    RelativeLayout rlrealname;
    @BindView(R.id.text_realname)
    TextView user_realname;
    @BindView(R.id.text_city)
    TextView user_city;
    @BindView(R.id.rl_userhead)
    RelativeLayout rluserhead;
    @BindView(R.id.image_userhead)
    CircleImageView user_head;
    @BindView(R.id.rl_bgimage)
    RelativeLayout rl_bg;
    @BindView(R.id.image_bgimage)
    ImageView user_bg;
    private static final int REQUEST_CODE_CHOOSE = 1001;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.rl_pick_sex)
    public void onViewClicked() {
        PickSexDialog dialog = new PickSexDialog();
        dialog.setmClickListener(new PickSexDialog.ClickListener() {
            @Override
            public void onSexPicked(String sex) {
                user_sex.setText(sex);
            }
        });
        dialog.show(getSupportFragmentManager(), PickSexDialog.TAG);
    }

    @OnClick(R.id.rl_birthday)
    public void onBirthdarClicked() {
        Calendar c = Calendar.getInstance(Locale.CHINA);
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog pickDateDialog = new DatePickerDialog(this, R.style.MyDatePickerDialog, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                mYear = year;
                mMonth = month + 1;
                mDay = day;
                birth.setText(year+"-"+(++month)+"-"+day);
            }
        }, mYear, mMonth, mDay);
        pickDateDialog.show();
    }

    @OnClick(R.id.toolbar_back)
    public void setToolbarBack() {
        finish();
    }
    private TextView view;
    @OnClick({R.id.rl_name,R.id.rl_introduction,R.id.rl_realname,R.id.rl_school})
    public void onClicked(View v){
        String title = "";
        switch (v.getId()){
            case R.id.rl_name:
                title = "修改昵称";
                view = user_name;
                break;
            case R.id.rl_introduction:
                title = "修改简介";
                view = user_introduction;
                break;
            case R.id.rl_realname:
                title = "修改姓名";
                view = user_realname;
                break;
            case R.id.rl_school:
                title = "修改学习";
                view = user_school;
                break;
        }
        WriteDialog dialog = new WriteDialog();
        dialog.titlecontent = title;
        dialog.content = view.getText().toString();
        dialog.setmClickListener(new WriteDialog.ClickListener() {
            @Override
            public void onPicked(String content) {
                view.setText(content);
            }
        });
        dialog.show(getSupportFragmentManager(),WriteDialog.TAG);
    }
    @OnClick(R.id.rl_cityselector)
    public void setCity(){
        CityPicker cityPicker = new CityPicker.Builder(EditInfoActivity.this)
                .textSize(14)
                .title("地址选择")
                .titleBackgroundColor("#FFFFFF")
                .titleTextColor("#000000")
                .confirTextColor("#000000")
                .cancelTextColor("#000000")
                .province("江苏省")
                .city("常州市")
                .district("天宁区")
                .textColor(Color.parseColor("#000000"))
                .provinceCyclic(true)
                .cityCyclic(false)
                .districtCyclic(false)
                .visibleItemsCount(7)
                .itemPadding(10)
                .onlyShowProvinceAndCity(false)
                .build();
        cityPicker.show();
        //监听方法，获取选择结果
        cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
            @Override
            public void onSelected(String... citySelected) {
                //省份
                String province = citySelected[0];
                //城市
                String city = citySelected[1];
                //区县（如果设定了两级联动，那么该项返回空）
                String district = citySelected[2];
                //邮编
                String code = citySelected[3];
                //为TextView赋值
                user_city.setText(province.trim() + "-" + city.trim() + "-" + district.trim());
            }

            @Override
            public void onCancel() {

            }
        });
    }
    @OnClick({R.id.rl_userhead,R.id.rl_bgimage})
    public void setImage(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //当前系统大于等于6.0
            if (ContextCompat.checkSelfPermission(EditInfoActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(EditInfoActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 999);
            }
            else {
                initImagemanager();
            }
        }
        else {
            initImagemanager();
        }

    }
    private void initImagemanager(){
        Matisse.from(this)
                .choose(MimeType.allOf())
                .countable(true)
                .maxSelectable(1)
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                .thumbnailScale(0.85f)
                .imageEngine(new GlideEngine())
                .theme(R.style.MyMatisseTheme)
                .forResult(REQUEST_CODE_CHOOSE);
    }
    List<Uri> mSelected;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            mSelected = Matisse.obtainResult(data);
            user_head.setImageURI(mSelected.get(0));
            user_bg.setImageURI(mSelected.get(0));
        }
    }
    /**
     * 获取权限
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 999) {
            if (grantResults.length >= 1) {
                int result = grantResults[0];//相关权限
                boolean Granted = result == PackageManager.PERMISSION_GRANTED;
                if (Granted) {
                    //具有权限
                    initImagemanager();
                } else {
                    //不具有相关权限，给予用户提醒，比如Toast或者对话框，让用户去系统设置-应用管理里把相关权限开启
                    ShowUtil.toast("请到设置中开启访问文件权限");
                }
            }
        }
    }
}
