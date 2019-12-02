package com.superc.yyfflibrary.utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by user on 2018/5/18.
 */

public class DateUtil {
    /**
     * 获取前n天日期、后n天日期
     *
     * @param distanceDay 前几天 如获取前7天日期则传-7即可；如果后7天则传7
     * @return
     */
    public static String getOldDate(int distanceDay) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) + distanceDay);
        Date endDate = null;
        try {
            endDate = dft.parse(dft.format(date.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.e("", "前7天==" + dft.format(endDate));
        return dft.format(endDate);
    }

    /**
     * 获取前n天日期、后n天日期
     *
     * @param distanceDay 前几天 如获取前7天日期则传-7即可；如果后7天则传7
     * @return
     */
    public static String getForeDate(String de, int distanceDay) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date endDate = null;
        try {
            Date beginDate = dft.parse(de);
            Calendar date = Calendar.getInstance();
            date.setTime(beginDate);
            date.set(Calendar.DATE, date.get(Calendar.DATE) + distanceDay);
            endDate = dft.parse(dft.format(date.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.e("", "前7天==" + dft.format(endDate));
        return dft.format(endDate);
    }


    /**
     * 字符串  转换成   时间戳
     * @param time:2019-11-20  15:56:30
     * @param simple_examp:yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getTimeLong(String time, String simple_examp) {
        SimpleDateFormat sdr = new SimpleDateFormat(simple_examp, Locale.CHINA);
        Date date;
        String times = null;
        try {
            date = sdr.parse(time);
            long l = date.getTime();
            String stf = String.valueOf(l);
            times = stf.substring(0, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return times;
    }

    /**
     * 将时间戳     转为   字符串
     * @param cc_time:1512132135不带毫秒
     * @param simple_examp:yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getTimeStr(String cc_time, String simple_examp) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat(simple_examp);
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }
}
