package com.superc.yyfflibrary.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    private static Toast mToast;

    public static void showToast(Context context, String msg){
        if(mToast==null){
            mToast=Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        }else {
            mToast.setText(msg);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void showToast(Context context,int msg_id){
        if(mToast==null){
            mToast=Toast.makeText(context,msg_id,Toast.LENGTH_SHORT);
        }else {
            mToast.setText(msg_id);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

}
