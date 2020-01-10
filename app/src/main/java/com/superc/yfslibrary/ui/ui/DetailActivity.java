package com.superc.yfslibrary.ui.ui;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.superc.yfslibrary.R;
import com.superc.yfslibrary.ui.ui.fragment.HomeFragment;
import com.superc.yfslibrary.ui.ui.fragment.MineFragment;
import com.superc.yyfflibrary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends BaseActivity {
    @BindView(R.id.detail_change)
    TextView mDetailChange;
    private boolean is_what=false;
    private FragmentTransaction mFragmentTransaction;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    public void init() {
        ButterKnife.bind(this);
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.add(R.id.detail_frame, new HomeFragment()).commit();
    }

    @OnClick({R.id.detail_change})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.detail_change:
                if(is_what){
                    getSupportFragmentManager().beginTransaction().add(R.id.detail_frame, new HomeFragment()).commit();
                }else{
                    getSupportFragmentManager().beginTransaction().add(R.id.detail_frame, new MineFragment()).commit();
                }
                toChangeTitleCor(is_what);
                is_what=!is_what;
                break;
        }
    }
}
