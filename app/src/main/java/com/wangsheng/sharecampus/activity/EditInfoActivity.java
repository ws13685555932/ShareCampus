package com.wangsheng.sharecampus.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.dialog.PickSexDialog;

import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditInfoActivity extends AppCompatActivity {

    @BindView(R.id.rl_pick_sex)
    RelativeLayout rlPickSex;
    @BindView(R.id.rl_birthday)
    RelativeLayout rlBirthday;
    @BindView(R.id.toolbar_back)
    ImageView toolbarBack;

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
        dialog.show(getSupportFragmentManager(), PickSexDialog.TAG);
    }

    @OnClick(R.id.rl_birthday)
    public void onBirthdarClicked() {
        Calendar c = Calendar.getInstance(Locale.CHINA);
        mYear = c.get(Calendar.YEAR);
        DatePickerDialog pickDateDialog = new DatePickerDialog(this, R.style.MyDatePickerDialog, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                mYear = year;
                mMonth = month + 1;
                mDay = day;
            }
        }, mYear, mMonth, mDay);
        pickDateDialog.show();
    }

    @OnClick(R.id.toolbar_back)
    public void setToolbarBack() {
        finish();
    }
}
