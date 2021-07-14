package com.superc.yyfflibrary.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.superc.yyfflibrary.utils.ToastUtil;
import com.superc.yyfflibrary.utils.titlebar.TitleUtils;

public abstract class BindBaseActivity extends AppCompatActivity {
    private static String TAG = "BindBaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        TitleUtils.getStatusBarHeight(this);
        super.onCreate(savedInstanceState);
        onBindCreat();
        TitleUtils.setStatusTextColor(false, this);
        TAG = getLocalClassName();
        init();

    }

    /**
     * @param cls 跳转到的Activity名称class
     */
    public void stAct(Class cls) {
        stAct(cls, null);
    }

    /**
     * @param bundle 跳转时携带的数据
     * @param cls    跳转到的Activity名称class
     */
    public void stAct(Class cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * @param msg 弹出提示类型--只支持String和Int索引
     */
    public void ToastShow(Object msg) {
        if (msg instanceof String) {
            ToastUtil.showToast(this, (String) msg);
        } else {
            ToastUtil.showToast(this, (int) msg);
        }
    }

    public void toChangeTitleCor(boolean is_deep) {
        TitleUtils.setStatusTextColor(is_deep, this);
    }

    public abstract void onBindCreat();

    public abstract void init();

}
