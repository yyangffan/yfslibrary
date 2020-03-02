package com.superc.yfslibrary.ui.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.superc.yfslibrary.R;
import com.superc.yyfflibrary.views.photoview.PhotoView;


public class DialogPicbig extends AlertDialog {
    private static final String TAG = "tupian+dig";
    private DialogPicbig mDialogPicbig;
    private PhotoView mPhotoView;
    private Context mContext;
    private String img_url;

    public DialogPicbig(Context context, String img_url) {
        super(context, R.style.WorkDialogTheme);
        this.img_url = img_url;
        mContext = context;
        mDialogPicbig=this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_pic);
        Window window = getWindow();
        window.setGravity(Gravity.CENTER);
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        window.getDecorView().setMinimumWidth(mContext.getResources().getDisplayMetrics().widthPixels);
        WindowManager.LayoutParams lps = window.getAttributes();
        lps.horizontalMargin = 0;
//        lps.verticalMargin = 0.02f;
        window.setAttributes(lps);
        window.setWindowAnimations(R.style.Dialog_ent_out);
        setCanceledOnTouchOutside(false);
        init();
    }

    private void init() {
        mPhotoView = findViewById(R.id.dialog_photo);
        Glide.with(mContext).load(img_url).into(mPhotoView);
        mPhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialogPicbig.dismiss();
            }
        });
    }
}
