package com.wangsheng.sharecampus.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * Created by windows8 on 2017/11/25.
 */

public class BitmapUtil {
    public static Bitmap compress(Bitmap bitmap,float quality){
        Matrix matrix = new Matrix();
        matrix.setScale(quality, quality);
        return  Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                bitmap.getHeight(), matrix, true);
    }
}
