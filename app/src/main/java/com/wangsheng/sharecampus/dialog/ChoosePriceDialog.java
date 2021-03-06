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

public class ChoosePriceDialog extends DialogFragment {

    public static final String TAG = "ChoosePriceDialog";
    @BindView(R.id.chooseprice_cancel)
    Button cancel;
    @BindView(R.id.chooseprice_true)
    Button confirm;
    @BindView(R.id.chooseprice_edit)
    EditText price;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_choose_price,container);
        ButterKnife.bind(this,view);
        return view;
    }
    private ClickListener mClickListener;

    public interface ClickListener {
        void onChoosePrice(int price);
    }
    public void setmClickListener(ClickListener l){
        mClickListener = l;
    }

    public void setClickListener(ClickListener mClickListener) {
        this.mClickListener = mClickListener;
    }
    @OnClick({R.id.chooseprice_cancel,R.id.chooseprice_true})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.chooseprice_cancel:
                dismiss();
                break;
            case R.id.chooseprice_true:
                int pricenum = Integer.parseInt(price.getText().toString());
                if(pricenum!= 0 && mClickListener!=null){
                    mClickListener.onChoosePrice(pricenum);
                    dismiss();
                }
                break;
        }
    }
}
