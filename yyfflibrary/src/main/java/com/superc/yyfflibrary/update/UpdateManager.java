package com.superc.yyfflibrary.update;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.FileProvider;
import android.util.Log;

import com.superc.yyfflibrary.BuildConfig;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateManager {

    private int progress;
    private String apkName="newBao.apk";
    private Context context;
//    private boolean isInterceptDownload;
    private OnProgressUpdateListener mOnProgressUpdateListener;
    private String urlString = "https://download.sj.qq.com/upload/connAssitantDownload/upload/MobileAssistant_1.apk";

    /**
     * 声明一个handler来跟进进度条
     */
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    // 更新进度情况
                    if (mOnProgressUpdateListener != null) {
                        mOnProgressUpdateListener.onProgressUpdateListener(progress, false);
                    }
                    break;
                case 0:
                    if (mOnProgressUpdateListener != null) {
                        mOnProgressUpdateListener.onProgressUpdateListener(100, true);
                        installApk();
                    }
                    break;
                default:
                    break;
            }
        }
    };

    public UpdateManager(Context context, String urlString) {
        super();
        this.context = context;
        this.urlString = urlString;
    }

    public void setOnProgressUpdateListener(OnProgressUpdateListener onProgressUpdateListener) {
        mOnProgressUpdateListener = onProgressUpdateListener;
    }

    /**
     * 开启新线程下载apk
     */
    public void downLoadApk() {
        Thread downloadThread = new Thread(downloadRunnable);
        downloadThread.start();
    }

    private Runnable downloadRunnable = new Runnable() {

        @Override
        public void run() {
            if (!Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                // 如果没有SD卡
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("提示");
                builder.setMessage("当前设备无SD卡，数据无法下载");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
                return;
            } else {
                try {
                    URL url = new URL(urlString);
                    HttpURLConnection connection;
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestProperty("Accept-Encoding", "identity");
                    connection.connect();
                    int length = connection.getContentLength();
                    InputStream is = connection.getInputStream();
                    File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/updateApkFile/");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    // 下载服务器中新版本软件（写文件）
                    String apkFileName = Environment.getExternalStorageDirectory().getAbsolutePath() + "/updateApkFile/" + apkName;
                    File apkFile = new File(apkFileName);
                    FileOutputStream fos = new FileOutputStream(apkFile);
                    int count = 0;
                    byte[] buf = new byte[1024];
                    while (true) {
                        // 当点击暂停时，则暂停下载
//                        if (!isInterceptDownload) {
                            int numRead = is.read(buf);
                            count += numRead;
                            progress = (int) (((float) count / length) * 100);
                            Log.d("安装包大小", "安装包大小：" + length + "  下载大小：" + count + "  下载百分比：" + progress);
                            handler.sendEmptyMessage(1);
                            if (numRead <= 0) {
                                // 下载完成通知安装
                                handler.sendEmptyMessage(0);
                                break;
                            }
                            fos.write(buf, 0, numRead);
//                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };


    /**
     * 安装，如果签名不一致，可能出现程序未安装提示
     */
    private void installApk() {
        File apkfile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/updateApkFile/" + apkName); // 获取当前sdcard存储路径
        if (!apkfile.exists()) {
            return;
        }
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            i.setDataAndType(FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".fileProvider", new File(apkfile.getAbsolutePath())), "application/vnd.android.package-archive");
            i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            i.setDataAndType(Uri.fromFile(new File(apkfile.getAbsolutePath())), "application/vnd.android.package-archive");
        }
        context.startActivity(i);
    }

    public interface OnProgressUpdateListener {
        void onProgressUpdateListener(int pros, boolean isEnd);
    }


}
