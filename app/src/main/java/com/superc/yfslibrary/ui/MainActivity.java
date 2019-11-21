package com.superc.yfslibrary.ui;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.superc.yfslibrary.R;
import com.superc.yfslibrary.ui.ui.DetailActivity;
import com.superc.yyfflibrary.base.BaseActivity;
import com.superc.yyfflibrary.utils.titlebar.TitleUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_click)
    TextView mMainClick;

    private boolean is_what = false;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        ButterKnife.bind(this);
        TitleUtils.setStatusTextColor(false, this);

    }

    @OnClick({R.id.main_click})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_click:
                if (is_what) {
                    TitleUtils.setStatusTextColor(false, MainActivity.this);
                    mMainClick.setText("时间简史");
                    statActivity(DetailActivity.class);
                    Log.e(TAG, "onClick: 时间简史");
                } else {
                    TitleUtils.setStatusTextColor(true, MainActivity.this);
                    mMainClick.setText("快乐时光");
                    Log.e(TAG, "onClick: 快乐时光");
                }
                is_what = !is_what;
                break;
        }
    }
}
