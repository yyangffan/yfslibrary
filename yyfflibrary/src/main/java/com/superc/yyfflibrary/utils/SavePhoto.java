package com.superc.yyfflibrary.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.net.ParseException;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/********************************************************************
  @version: 1.0.0
  @description: 保存图片
  @author: EDZ
  @time: 2019/11/20 16:06
  @变更历史:
********************************************************************/
public class SavePhoto {//存调用该类的活动
    Context context;
    private static volatile SavePhoto savePhoto;

    private SavePhoto(Context context) {
        this.context = context;
    }

    public static SavePhoto getInstance(Context context) {
        if (savePhoto == null) {
            synchronized (SavePhoto.class) {
                if (savePhoto == null) {
                    savePhoto = new SavePhoto(context);
                }
            }
        }
        return savePhoto;
    }
    //保存文件的方法：
    public void SaveBitmapFromView(View view) throws ParseException {
        int w = view.getWidth();
        int h = view.getHeight();
        Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmp);
        view.layout(0, 0, w, h);
        view.draw(c);
        // 缩小图片
        Matrix matrix = new Matrix();
        matrix.postScale(0.5f, 0.5f); //长和宽放大缩小的比例
        bmp = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, true);
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        saveBitmap(bmp, bmp.toString() + ".JPEG");
    }

    /**
     *
     * @param bitmap    要保存的文件Bitmap类型
     * @param filename  要保存的文件名
     * @return
     */
    public String saveImage(Bitmap bitmap,String filename) {
        String saveImagePath = null;
        String imageFileName = filename + ".jpg";
        File storageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "生活码");
        boolean success = true;
        if (!storageDir.exists()) {
            success = storageDir.mkdirs();
        }
        if (success) {
            File imageFile = new File(storageDir, imageFileName);
            saveImagePath = imageFile.getAbsolutePath();
            try {
                OutputStream fout = new FileOutputStream(imageFile);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fout);
                fout.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            galleryAddPic(saveImagePath);
            Toast.makeText(context,"图片"+filename+"已保存", Toast.LENGTH_LONG).show();
        }
        return saveImagePath;
    }

    private void galleryAddPic(String imagePath) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(imagePath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        context.sendBroadcast(mediaScanIntent);
    }
    /*
     * 保存文件，文件名为当前日期
     */
    public void saveBitmap(Bitmap bitmap, String bitName) {
        String fileName;
        File file;
        if (Build.BRAND.equals("Xiaomi")) { // 小米手机
            fileName = Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera/" + bitName;
        } else { // Meizu 、Oppo
            Log.v("qwe", "002");
            fileName = Environment.getExternalStorageDirectory().getPath() + "/DCIM/" + bitName;
        }
        file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            // 格式为 JPEG，照相机拍出的图片为JPEG格式的，PNG格式的不能显示在相册中
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out)) {
                out.flush();
                out.close();
                // 插入图库
                MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), bitName, null);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 发送广播，通知刷新图库的显示
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + fileName)));
    }
}
