package com.example.administrator.flexiblesearchbar;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by huangweiliang on 2018/2/27.
 */

public class DisplayUtil{
    public static int dp2px(Context context, int dpValue){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dpValue,context.getResources().getDisplayMetrics());
    }
    public static int sp2px(Context context,int spValue){
        return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,spValue,context.getResources().getDisplayMetrics());
    }


}
