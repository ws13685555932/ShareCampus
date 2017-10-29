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

public class ChoosePriceDialog extends DialogFragment {

    public static final String TAG = "ChoosePriceDialog";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_choose_price,container);
        return view;
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
}
