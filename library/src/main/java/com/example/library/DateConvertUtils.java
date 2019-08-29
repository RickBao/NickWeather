package com.example.library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class DateConvertUtils {

    public static final String DATE_FORMAT_PATTEN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_PATTEN_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String DATE_FORMAT_PATTEN_YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 将时间转化为时间戳
     * @param date              待转换的日期
     * @param dateFormatPatten  待转换日期格式
     * @return
     */
    public static long dateToTimeStamp(String date, String dateFormatPatten) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatPatten, Locale.CHINA);
        Date idate = null;
        try {
            idate = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assert idate != null;
        return idate.getTime();
    }

    /**
     * 将时间戳转化为日期
     * @param time              待转化的时间戳
     * @param dateFormatPatten  待转出的日期格式
     * @return
     */
    public static String timeStampToDate(long time, String dateFormatPatten) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatPatten, Locale.CHINA);
        Date date = new Date(time);
        return simpleDateFormat.format(date);
    }

    /**
     * 日期转星期
     * @param dateString    日期
     * @return              星期（周一，周二...)
     */
    public static String convertDateToWeek(String dateString) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_PATTEN_YYYY_MM_DD, Locale.CHINA);
        Date idate = null;
        try {
            idate = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (isNow(idate)) {
            return "今天";
        }

        String[] weekDaysName = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(idate);
        int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDaysName[intWeek];
    }

    /**
     * 日期转换
     * @param dateString    待转换的日期
     * @return              ex: 返回08.30
     */
    public static String convertDateToString(String dateString) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_PATTEN_YYYY_MM_DD, Locale.CHINA);
        Date idate = null;
        try {
            idate = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (idate == null) {
            return "";
        }

        return (String.valueOf(idate.getMonth()).length() == 1 ? "0" + idate.getMonth() :
                String.valueOf(idate.getMonth())) + "." + (String.valueOf(idate.getDay()).length() == 1 ?
                "0" + idate.getDay() : String.valueOf(idate.getDay()));
    }

    /**
     * 判断时间是不是今天
     * @param date  待判断的时间
     * @return      是今天返回true，不是今天返回false
     */
    private static boolean isNow(Date date) {

        //当前时间
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_PATTEN_YYYY_MM_DD, Locale.CHINA);
        //获取今天的日期
        String nowDay = simpleDateFormat.format(now);
        //对比时间
        String day = simpleDateFormat.format(date);

        return day.equals(nowDay);
    }
}
