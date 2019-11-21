package com.superc.yfslibrary.ui.ui;

import android.util.Log;

import com.superc.yfslibrary.R;
import com.superc.yyfflibrary.base.BaseActivity;

public class DetailActivity extends BaseActivity {


    @Override
    public int getContentLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    public void init() {
        Log.e(TAG, "init: 好坏了还算了");
    }
}
