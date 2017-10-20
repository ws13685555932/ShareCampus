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
import android.widget.EditText;
import android.widget.TextView;

import com.wangsheng.sharecampus.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by windows8 on 2017/10/19.
 */

public class WriteDialog extends DialogFragment {
    public static final String TAG = "WriteDialog";
    @BindView(R.id.btn_cancel)
    Button btnCancel;
    @BindView(R.id.btn_confirm)
    Button btnConfirm;
    @BindView(R.id.writedialog_title)
    TextView title;
    @BindView(R.id.edit_name)
    EditText name;
    public String titlecontent;
    public String content;
    Unbinder unbinder;
    private float mShowAlpha = 0.8f;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_write, container, false);
        unbinder = ButterKnife.bind(this, view);
        title.setText(titlecontent);
        name.setText(content);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_cancel, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel:
                dismiss();
                break;
            case R.id.btn_confirm:
                String namecontent = name.getText().toString();
                dismiss();
                if (mClickListener != null&&namecontent.length()!=0) {
                    mClickListener.onPicked(namecontent);
                }
                break;
        }
    }

    private ClickListener mClickListener;

    public interface ClickListener {
        void onPicked(String content);
    }
    public void setmClickListener(ClickListener l)
    {
        mClickListener  = l;
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
