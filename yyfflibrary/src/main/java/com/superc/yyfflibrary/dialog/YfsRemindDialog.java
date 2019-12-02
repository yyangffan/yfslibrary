package com.superc.yyfflibrary.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.superc.yyfflibrary.R;


public class YfsRemindDialog extends AlertDialog {
    private View mView;
    private Context mContext;
    private OnTextClickListener mOnTextClickListener;
    private String title;
    private String content;
    private String left;
    private String right;
    private int left_color;
    private int right_color;
    private int con_txt_gra;
    private int icon_pos;
    private TextView mtv_title;
    private TextView mtv_content;
    private TextView mtv_left;
    private TextView mtv_right;
    private View mtv_btline;
    private View mtv_one;
    private View mtv_two;
    private ImageView mImageView;

    private YfsRemindDialog mPhaseRemindDialog;
    private final Window mWindow;
    private Display mDisplay;


    public YfsRemindDialog(Context context, Builder builder) {
        super(context,R.style.AlertDialogTheme);
        setCanceledOnTouchOutside(false);
        mContext = context;
        mPhaseRemindDialog = this;
        mWindow = getWindow();
        mWindow.setBackgroundDrawable(new ColorDrawable(0x0000ffff));
        mWindow.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        mDisplay=getWindow().getWindowManager().getDefaultDisplay();
        title = builder.title;
        content = builder.content;
        con_txt_gra = builder.con_txt_gra;
        left = builder.left;
        icon_pos = builder.icon_pos;
        right = builder.right;
        left_color = builder.left_color;
        right_color = builder.right_color;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = LayoutInflater.from(mContext).inflate(R.layout.dialog_remind, null);
        initView();
        setContentView(mView);
    }

    public void setOnTextClickListener(OnTextClickListener onTextClickListener) {
        mOnTextClickListener = onTextClickListener;
    }

    @Override
    public void show() {
        super.show();
        mWindow.setWindowAnimations(R.style.Pop_inOut_anim);
        Window window = mPhaseRemindDialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (mDisplay.getWidth() * 0.7);
        window.setAttributes(attributes);
    }

    private void initView() {
        mtv_title = mView.findViewById(R.id.dialog_remind_title);
        mtv_content = mView.findViewById(R.id.dialog_remind_content);
        mtv_left = mView.findViewById(R.id.dialog_remind_left);
        mtv_right = mView.findViewById(R.id.dialog_remind_right);
        mImageView = mView.findViewById(R.id.dialog_remind_imgv);
        mtv_btline = mView.findViewById(R.id.dialog_remind_btline);
        mtv_one = mView.findViewById(R.id.phase_remidig_one);
        mtv_two = mView.findViewById(R.id.phase_remidig_two);
        setCon(mtv_title, title);
        setCon(mtv_content, content);
        setCon(mtv_left, left);
        setCon(mtv_right, right);
        if(TextUtils.isEmpty(content)){
            mtv_one.setVisibility(View.VISIBLE);
            mtv_two.setVisibility(View.VISIBLE);
        }
        mtv_btline.setVisibility(TextUtils.isEmpty(right) ? View.GONE : View.VISIBLE);
        if (con_txt_gra != 0) {
            mtv_content.setGravity(con_txt_gra);
        }
        if (icon_pos != 0) {
            mImageView.setImageResource(icon_pos);
        }
        mtv_left.setTextColor(left_color == 0 ? Color.parseColor("#666666") : mContext.getResources().getColor(left_color));
        mtv_right.setTextColor(right_color == 0 ? mContext.getResources().getColor(R.color.main_color) : mContext.getResources().getColor(right_color));
        mtv_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnTextClickListener != null) {
                    mOnTextClickListener.onLeftClickListener();
                }
                mPhaseRemindDialog.dismiss();
            }
        });
        mtv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnTextClickListener != null) {
                    mOnTextClickListener.onRightClickListener();
                }
                mPhaseRemindDialog.dismiss();
            }
        });

    }

    private void setCon(TextView tv, String con) {
        tv.setVisibility(TextUtils.isEmpty(con) ? View.GONE : View.VISIBLE);
        tv.setText(con);
    }

    public static abstract class OnTextClickListener {
        public void onLeftClickListener() {

        }

        public void onRightClickListener() {

        }
    }

    public static class Builder {
        private String title;
        private String content;
        private String left;
        private String right;
        private int left_color;
        private int right_color;
        private Context mContext;
        private int con_txt_gra;
        private int icon_pos;

        public Builder(Context context) {
            mContext = context;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder left(String left) {
            this.left = left;
            return this;
        }

        public Builder right(String right) {
            this.right = right;
            return this;
        }

        public Builder left_color(int left_color) {
            this.left_color = left_color;
            return this;
        }

        public Builder right_color(int right_color) {
            this.right_color = right_color;
            return this;
        }

        public Builder con_txt_gra(int con_txt_gra) {
            this.con_txt_gra = con_txt_gra;
            return this;
        }

        public Builder icon_pos(int icon_pos) {
            this.icon_pos = icon_pos;
            return this;
        }

        public YfsRemindDialog build() {
            return new YfsRemindDialog(mContext, this);
        }

    }


}

