package com.wangsheng.sharecampus.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/5/10.
 */

public class PickSexDialog extends DialogFragment {
    public static final String TAG = "PickSexDialog";
    @BindView(R.id.ll_pick_male)
    LinearLayout llPickMale;
    @BindView(R.id.ll_pick_secret)
    LinearLayout llPickSecret;
    @BindView(R.id.ll_pick_female)
    LinearLayout llPickFemale;
    @BindView(R.id.btn_cancel)
    Button btnCancel;
    @BindView(R.id.btn_confirm)
    Button btnConfirm;
    Unbinder unbinder;
    @BindView(R.id.iv_male)
    ImageView ivMale;
    @BindView(R.id.tv_male)
    TextView tvMale;
    @BindView(R.id.iv_secret)
    ImageView ivSecret;
    @BindView(R.id.tv_secret)
    TextView tvSecret;
    @BindView(R.id.iv_female)
    ImageView ivFemale;
    @BindView(R.id.tv_female)
    TextView tvFemale;
    private float mShowAlpha = 0.8f;
    private String mSex;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_pick_sex, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.ll_pick_male, R.id.ll_pick_secret, R.id.ll_pick_female, R.id.btn_cancel, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_pick_male:
                removeAllBackground();
                llPickMale.setBackgroundResource(R.drawable.bg_pick_sex_male);
                mSex = "男";
                break;
            case R.id.ll_pick_secret:
                removeAllBackground();
                llPickSecret.setBackgroundResource(R.drawable.bg_pick_sex_secret);
                mSex = "保密";
                break;
            case R.id.ll_pick_female:
                removeAllBackground();
                llPickFemale.setBackgroundResource(R.drawable.bg_pick_sex_female);
                mSex = "女";
                break;
            case R.id.btn_cancel:
                dismiss();
                break;
            case R.id.btn_confirm:
                dismiss();
                if (mClickListener != null) {
                    mClickListener.onSexPicked(mSex);
                }
                break;
        }
    }

    private void removeAllBackground() {
        llPickFemale.setBackgroundColor(getResources().getColor(R.color.transparent));
        llPickMale.setBackgroundColor(getResources().getColor(R.color.transparent));
        llPickSecret.setBackgroundColor(getResources().getColor(R.color.transparent));
    }

    private ClickListener mClickListener;

    public interface ClickListener {
        void onSexPicked(String sex);
    }
    public void setmClickListener(ClickListener l){
        mClickListener = l;
    }

    public void setClickListener(ClickListener mClickListener) {
        this.mClickListener = mClickListener;
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
    }


}
