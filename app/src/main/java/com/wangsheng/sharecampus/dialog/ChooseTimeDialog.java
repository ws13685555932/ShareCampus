package com.wangsheng.sharecampus.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.wangsheng.sharecampus.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangsheng
 * on 2017/10/2.
 */

public class ChooseTimeDialog extends DialogFragment {
    public static final String TAG = "ChooseTimeDialog";
    @BindView(R.id.choosetime_cancel)
    Button cancel;
    @BindView(R.id.choosetime_date)
    EditText date;
    @BindView(R.id.choosetime_hour)
    EditText hour;
    @BindView(R.id.choosetime_month)
    EditText month;
    @BindView(R.id.choosetime_true)
    Button confirm;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_choose_time,container);
        ButterKnife.bind(this,view);
        return view;

    }
    private ClickListener mClickListener;

    public interface ClickListener {
        void onChooseTime(int month,int date,int hour);
    }
    public void setmClickListener(ClickListener l){
        mClickListener = l;
    }

    public void setClickListener(ClickListener mClickListener) {
        this.mClickListener = mClickListener;
    }
    @OnClick({R.id.choosetime_cancel,R.id.choosetime_true})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.choosetime_cancel:
                dismiss();
                break;
            case R.id.choosetime_true:
                int monthnum = Integer.parseInt(month.getText().toString());
                int datenum = Integer.parseInt(date.getText().toString());
                int hournum = Integer.parseInt(hour.getText().toString());
                if((monthnum!=0||datenum!=0||hournum!=0)&&mClickListener!=null){
                    mClickListener.onChooseTime(monthnum,datenum,hournum);
                    dismiss();
                }
                break;
        }
    }
}
