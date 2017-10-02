package com.wangsheng.sharecampus;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;

import com.wangsheng.sharecampus.util.DensityUtil;

import static android.R.attr.width;

/**
 * Created by wangsheng
 * on 2017/10/2.
 */

public class IconTextView extends AppCompatTextView {

    private int iconWidth;
    private int iconHeight;


    public IconTextView(Context context) {
        super(context);
    }

    public IconTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getAttrs(context,attrs);
        initDrawable();
    }

    public IconTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttrs(context,attrs);
        initDrawable();
    }

    private void getAttrs(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.IconTextView);
        iconWidth = (int) ta.getDimension(R.styleable.IconTextView_iconWidth,18);
        iconHeight = (int) ta.getDimension(R.styleable.IconTextView_iconHeight,18);
        Log.d(TAG, "getAttrs: " + iconHeight + "===" +iconWidth);
        ta.recycle();
    }

    private void initDrawable() {
        Drawable left = this.getCompoundDrawables()[0];
        if (left != null) {
            Log.d(TAG, "initDrawable: ");
            left.setBounds(0,0,iconWidth,iconHeight);
            this.setCompoundDrawables(left, null, null, null);
        }
    }

    private static final String TAG = "IconTextView";

}
