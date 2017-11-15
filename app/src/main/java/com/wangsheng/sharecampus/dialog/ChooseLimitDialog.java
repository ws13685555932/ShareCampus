package com.wangsheng.sharecampus.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangsheng
 * on 2017/10/2.
 */

public class ChooseLimitDialog extends DialogFragment {
    public static final String TAG = "ChooseLimitDialog";
    @BindView(R.id.chooselimit_cancel)
    Button cancel;
    @BindView(R.id.chooselimit_seekbar)
    SeekBar seekBar;
    @BindView(R.id.chooselimit_true)
    Button confirm;
    @BindView(R.id.chooselimit_num)
    TextView num;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_choose_limit,container);
        ButterKnife.bind(this,view);
        num.setText(0+"");
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                num.setText((i/5)+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        return view;

    }
    private ClickListener mClickListener;

    public interface ClickListener {
        void onChooseLimit(int num);
    }
    public void setmClickListener(ClickListener l){
        mClickListener = l;
    }

    @OnClick({R.id.chooselimit_cancel,R.id.chooselimit_true})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.chooselimit_cancel:
                dismiss();
                break;
            case R.id.chooselimit_true:
                int peoplenum = Integer.parseInt(num.getText().toString());
                if(peoplenum != 0 && mClickListener != null){
                    mClickListener.onChooseLimit(peoplenum);
                    dismiss();
                }
                break;
        }
    }
}
