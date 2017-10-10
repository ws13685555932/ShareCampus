package com.wangsheng.sharecampus.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.wangsheng.sharecampus.R;

/**
 * Created by wangsheng
 * on 2017/10/2.
 */

public class ChooseTimeFragment extends DialogFragment {
    public static final String TAG = "ChooseTimeFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_choose_time,container);
        return view;

    }
}