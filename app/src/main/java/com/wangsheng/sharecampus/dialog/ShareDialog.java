package com.wangsheng.sharecampus.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.wangsheng.sharecampus.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by windows8 on 2017/10/20.
 */

public class ShareDialog extends DialogFragment {
    public static final String TAG = "ShareDialog";
    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
//        View view = inflater.inflate(R.layout.dialog_share, container, false);
//        unbinder = ButterKnife.bind(this, view);
//        return view;
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = 1.0f;
        getActivity().getWindow().setAttributes(lp);
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }
    @Nullable
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // 使用不带Theme的构造器, 获得的dialog边框距离屏幕仍有几毫米的缝隙。
        WindowManager.LayoutParams lp2 = getActivity().getWindow().getAttributes();
        lp2.alpha = 0.6f;
        getActivity().getWindow().setAttributes(lp2);
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        Dialog dialog = new Dialog(getActivity(), R.style.BottomDialog);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 设置Content前设定
        dialog.setContentView(R.layout.dialog_share);
        dialog.setCanceledOnTouchOutside(true); // 外部点击取消
        // 设置宽度为屏宽, 靠近屏幕底部。
        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM; // 紧贴底部
        lp.width = WindowManager.LayoutParams.MATCH_PARENT; // 宽度持平
        window.setAttributes(lp);

        unbinder = ButterKnife.bind(this, dialog);
        return dialog;
    }
}
