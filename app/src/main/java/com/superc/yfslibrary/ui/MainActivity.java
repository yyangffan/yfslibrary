package com.superc.yfslibrary.ui;

import android.view.View;
import android.widget.TextView;

import com.superc.yfslibrary.R;
import com.superc.yfslibrary.ui.customdate.CustomDatePicker;
import com.superc.yfslibrary.ui.customdate.DateFormatUtils;
import com.superc.yfslibrary.ui.ui.DetailActivity;
import com.superc.yyfflibrary.base.BaseActivity;
import com.superc.yyfflibrary.utils.titlebar.TitleUtils;
import com.superc.yyfflibrary.views.CircleImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/********************************************************************
 @version: 1.0.0
 @description:
 @author: EDZ
 @time: 2019/11/21 15:20
 @变更历史:
 ********************************************************************/
public class MainActivity extends BaseActivity {

    @BindView(R.id.main_click)
    TextView mMainClick;
    @BindView(R.id.main_circle)
    CircleImageView mCircleImageView;
    private boolean is_what = false;
    private CustomDatePicker mTimerPicker;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        ButterKnife.bind(this);
        TitleUtils.setStatusTextColor(false, this);
        initDate();
    }

    @OnClick({R.id.main_click, R.id.main_circle})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_click:
                if (is_what) {
                    TitleUtils.setStatusTextColor(false, MainActivity.this);
                    mMainClick.setText("时间简史");
                    statActivity(DetailActivity.class);
                } else {
                    TitleUtils.setStatusTextColor(true, MainActivity.this);
                    mMainClick.setText("快乐时光");
                }
                is_what = !is_what;
                break;
            case R.id.main_circle:
                mTimerPicker.show(mMainClick.getText().toString());
                break;
        }
    }

    private void initDate() {
        mMainClick.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));


        initDatePick();
    }
    private void initDatePick(){
        long beginTimestamp = DateFormatUtils.str2Long("2009-05-01", false);
        long endTimestamp = System.currentTimeMillis();

        // 通过日期字符串初始化日期，格式请用：yyyy-MM-dd HH:mm
        mTimerPicker = new CustomDatePicker(this, new CustomDatePicker.Callback() {
            @Override
            public void onTimeSelected(long timestamp) {
                mMainClick.setText(DateFormatUtils.long2Str(timestamp, true));
            }
        }, beginTimestamp, endTimestamp);
        // 允许点击屏幕或物理返回键关闭
        mTimerPicker.setCancelable(true);
        // 显示时和分
        mTimerPicker.setCanShowPreciseTime(false);
        // 允许循环滚动
        mTimerPicker.setScrollLoop(true);
        // 允许滚动动画
        mTimerPicker.setCanShowAnim(true);

    }



}
