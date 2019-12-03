package com.superc.yyfflibrary.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.superc.yyfflibrary.utils.ToastUtil;

public abstract class BaseFragment extends Fragment {

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(getContentLayoutId(), container, false);
    }
*/

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
        Intent intent = new Intent(this.getActivity(), cls);
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
            ToastUtil.showToast(this.getActivity(), (String) msg);
        } else {
            ToastUtil.showToast(this.getActivity(), (int) msg);
        }
    }


    /*public abstract int getContentLayoutId();*/

    public abstract void init();

}
