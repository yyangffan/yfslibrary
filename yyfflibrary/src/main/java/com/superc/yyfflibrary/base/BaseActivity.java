package com.superc.yyfflibrary.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;

import com.superc.yyfflibrary.slide.SlideBackActivity;
import com.superc.yyfflibrary.utils.ToastUtil;
import com.superc.yyfflibrary.utils.titlebar.TitleUtils;


/********************************************************************
 @version: 1.0.0
 @description: TitleUtils为修改标题栏颜色的公共类
 说明： 1、 TitleUtils.setStatusTextColor(false, this);中一参false为浅色 true为深色，方法在init中调用
 2、setSlideable(false);表示不使用滑动退出  true表示使用
 @author: EDZ
 @time: 2019/11/20 14:41
 @变更历史:
 ********************************************************************/

public abstract class BaseActivity extends SlideBackActivity {
    public String TAG = "BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        TitleUtils.getStatusBarHeight(this);
        super.onCreate(savedInstanceState);
        setContentView(LayoutInflater.from(this).inflate(getContentLayoutId(), null));
        TitleUtils.setStatusBar(this, false, false);
        TAG = getLocalClassName();
        init();

    }

    /**
     * @param cls 跳转到的Activity名称class
     */
    public void statActivity(Class cls) {
        statActivity(cls, null);
    }

    /**
     * @param bundle 跳转时携带的数据
     * @param cls    跳转到的Activity名称class
     */
    public void statActivity(Class cls, Bundle bundle) {
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

    public void toChangeTitleCor(boolean is_deep){
        TitleUtils.setStatusTextColor(is_deep, this);
    }


    public abstract int getContentLayoutId();

    public abstract void init();

}
