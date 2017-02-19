package com.wenld.commontools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SuppressLint("SimpleDateFormat")
public class DateUtil {

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final int YMDHMS_LINE = 11;
    /**
     * yyyy-MM-dd
     */
    public static final int YMD_LINE = 12;
    /**
     * MM-dd
     */
    public static final int MD_LINE = 13;
    /**
     * HH:mm
     */
    public static final int HM = 14;
    /**
     * yyyy年MM月dd日
     */
    public static final int YMD_CHIN = 22;
    /**
     * MM月dd日
     */
    public static final int MD_CHIN = 23;
    /**
     * yyyy.MM.dd
     */
    public static final int YMD_DOT = 32;
    /**
     * MM.dd
     */
    public static final int MD_DOT = 33;

    private static SimpleDateFormat ymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat ymd_dot = new SimpleDateFormat("yyyy.MM.dd");
    private static SimpleDateFormat nyr = new SimpleDateFormat("yyyy年MM月dd日");
    private static SimpleDateFormat yr = new SimpleDateFormat("MM月dd日");
    private static SimpleDateFormat md = new SimpleDateFormat("MM-dd");
    private static SimpleDateFormat hm = new SimpleDateFormat("HH:mm");
    private static SimpleDateFormat md_dot = new SimpleDateFormat("MM.dd");


    /**
     * 获取传入时间的对应时间long值
     *
     * @param calendar
     * @return
     */
    public static long getTimeLong(Calendar calendar) {
        return calendar.getTimeInMillis();
    }

    /**
     * 根据类型获取传入时间calendar的对应字符串
     *
     * @param calendar
     * @param type
     * @return
     */
    public static String getTimeString(Calendar calendar, int type) {
        return getTimeString(calendar.getTime(), type);
    }

    /**
     * 将long类型时间转为对应type的字符串
     *
     * @param millis
     * @return
     */
    public static String getTimeString(long millis, int type) {
        return getTimeString(new Date(millis), type);
    }

    /**
     * 将Date类型时间转为对应type的字符串
     *
     * @return
     */
    @SuppressWarnings("finally")
    public static String getTimeString(Date date, int type) {
        String retStr = "";
        try {
            switch (type) {
                case YMDHMS_LINE:
                    retStr = ymdhms.format(date);
                    break;
                case YMD_LINE:
                    retStr = ymd.format(date);
                    break;
                case MD_LINE:
                    retStr = md.format(date);
                    break;
                case HM:
                    retStr = hm.format(date);
                    break;
                case YMD_CHIN:
                    retStr = nyr.format(date);
                    break;
                case MD_CHIN:
                    retStr = yr.format(date);
                    break;
                case YMD_DOT:
                    retStr = ymd_dot.format(date);
                    break;
                case MD_DOT:
                    retStr = md_dot.format(date);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            LogUtil.d("TimeTransformation", "时间转换字符串失败！");
        } finally {
            return retStr;
        }
    }

    /**
     * 根据类型获取传入字符串的时间 、-1为当前时间
     *
     * @param type
     * @return
     */
    @SuppressWarnings("finally")
    public static Calendar getTimeCalendar(String date, int type) {
        Calendar calendar = Calendar.getInstance();
        try {
            switch (type) {
                case YMDHMS_LINE:
                    calendar.setTime(ymdhms.parse(date));
                    break;
                case YMD_LINE:
                    calendar.setTime(ymd.parse(date));
                    break;
                case YMD_CHIN:
                    calendar.setTime(nyr.parse(date));
                    break;
                case YMD_DOT:
                    calendar.setTime(ymd_dot.parse(date));
                    break;
                case MD_CHIN:
                    calendar.setTime(yr.parse(date));
                    break;
                case MD_LINE:
                    calendar.setTime(md.parse(date));
                    break;
                case HM:
                    calendar.setTime(hm.parse(date));
                    break;
                case MD_DOT:
                    calendar.setTime(md_dot.parse(date));
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            LogUtil.d("TimeTransformation", "字符串转换时间失败！");
        } finally {
            return calendar;
        }
    }

    /**
     * 将一格式字符串转为另一格式字符串
     *
     * @param date    转换前时间字符串
     * @param newtype 转换后格式
     * @param oldtype 转换前格式
     * @return
     */
    public static String transformTimeString(String date, int newtype,
                                             int oldtype) {
        if (newtype == oldtype) {
            return date;
        }
        String newdate = getTimeString(getTimeCalendar(date, oldtype), newtype);
        return TextUtils.isEmpty(newdate) ? date : newdate;
    }

    /**
     * 根据类型比较agodate与afterdate时间前后：
     *
     * @param agodate
     * @param afterdate
     * @param type
     * @return 0为相等、1为agodate前、-1为afterdate前
     */
    public static int compareTime(String agodate, String afterdate, int type) {
        if (agodate.equals(afterdate)) {
            return 0;
        } else if (getTimeLong(getTimeCalendar(agodate, type)) > getTimeLong(getTimeCalendar(
                afterdate, type))) {
            return 1;
        }
        return -1;
    }

    /**
     * 根据类型比较agodate与afterdate时间前后：
     *
     * @param agodate   时间1
     * @param agotype   时间1类型
     * @param afterdate 时间2
     * @param aftertype 时间2类型
     * @return 0为相等、1为agodate前、-1为afterdate前
     */
    public static int compareTime(String agodate, int agotype,
                                  String afterdate, int aftertype) {
        if (agotype != aftertype) {
            afterdate = transformTimeString(afterdate, agotype, aftertype);
        }
        return compareTime(agodate, afterdate, agotype);
    }

    /**
     * 西方默认周日为一周的第一天，此方法获取以周一为第一天的一周的第N天
     *
     * @return 第几天. 例：周一返回 1；周日返回 7
     */
    public static int getOurWeek(Calendar calendar) {
        int week = calendar.get(Calendar.DAY_OF_WEEK);// 西方算法、周日为一周的第一天
        return week == 1 ? 7 : week - 1;// 因周日为一周的第一天，故减1
    }

    /**
     * 根据1`7获取对应的星期
     *
     * @param context
     * @param week
     * @return
     */
    public static String getWeek(Context context, int week) {
        switch (week) {
            case 1:
                return context.getString(R.string.week)
                        + context.getString(R.string.mon);
            case 2:
                return context.getString(R.string.week)
                        + context.getString(R.string.tue);
            case 3:
                return context.getString(R.string.week)
                        + context.getString(R.string.wed);
            case 4:
                return context.getString(R.string.week)
                        + context.getString(R.string.thr);
            case 5:
                return context.getString(R.string.week)
                        + context.getString(R.string.fri);
            case 6:
                return context.getString(R.string.week)
                        + context.getString(R.string.sat);
            default:
                return context.getString(R.string.week)
                        + context.getString(R.string.sun);
        }
    }

    /**
     * 两个时间是否是同一周
     */
    public static boolean isSameWeek(String date1, String date2) {
        return isSameWeek(date1, date2, YMD_LINE);
    }

    /**
     * 两个时间是否是同一周
     *
     * @param type 转化时间类型
     */
    public static boolean isSameWeek(String date1, String date2, int type) {
        Calendar cal1 = getTimeCalendar(date1, type);
        Calendar cal2 = getTimeCalendar(date2, type);
        cal1.add(Calendar.DAY_OF_YEAR, -1);
        cal2.add(Calendar.DAY_OF_YEAR, -1);
        int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
        // subYear==0,说明是同一年
        if (subYear == 0) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
                    .get(Calendar.WEEK_OF_YEAR))
                return true;
        }
        // 例子:cal1是"2005-1-1"，cal2是"2004-12-25"
        // java对"2004-12-25"处理成第52周
        // "2004-12-26"它处理成了第1周，和"2005-1-1"相同了
        // 大家可以查一下自己的日历
        // 处理的比较好
        // 说明:java的一月用"0"标识，那么12月用"11"
        else if (subYear == 1 && cal2.get(Calendar.MONTH) == 11) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
                    .get(Calendar.WEEK_OF_YEAR))
                return true;
        }
        // 例子:cal1是"2004-12-31"，cal2是"2005-1-1"
        else if (subYear == -1 && cal1.get(Calendar.MONTH) == 11) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
                    .get(Calendar.WEEK_OF_YEAR))
                return true;

        }
        return false;
    }

    public static int compareYear(long time1, long time2){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time1);
        int year1 = calendar.get(Calendar.YEAR);
        calendar.setTimeInMillis(time2);
        int year2 = calendar.get(Calendar.YEAR);
        return year1 - year2;
    }

    /**
     * 时间格式显示规则-简洁型
     * 当天内，显示格式为“16：04”（小时-分钟）。
     * 昨天的消息，显示格式为“昨天”。
     * 昨天以前的，显示格式为“09-19”（月份-日期）。
     */
    public static String switchToSimpleTime(String switchTime) {
        try {
            String returnTime;
            Calendar calendarTime = getTimeCalendar(switchTime, DateUtil.YMDHMS_LINE);
            Long time = getTimeLong(calendarTime);
            Calendar calendar = Calendar.getInstance();
            int curYear = calendar.get(Calendar.YEAR);
            int curMonth = calendar.get(Calendar.MONTH);
            int curDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
            calendar.setTimeInMillis(time);
            int msgYear = calendar.get(Calendar.YEAR);
            int msgMonth = calendar.get(Calendar.MONTH);
            int msgDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
            if (curYear == msgYear && curMonth == msgMonth
                    && curDayOfMonth == msgDayOfMonth) {
                returnTime = String.format("%02d:%02d",
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE));
            } else if (curYear == msgYear && curMonth == msgMonth
                    && curDayOfMonth - 1 == msgDayOfMonth) {
                returnTime = "昨天";
            } else {
                returnTime = String
                        .format("%02d-%02d", msgMonth + 1, msgDayOfMonth);
//                        + " "
//                        + String.format("%02d:%02d",
//                        calendar.get(Calendar.HOUR_OF_DAY),
//                        calendar.get(Calendar.MINUTE));
            }
            return returnTime;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String formatQuickly(String format, long time){
        try {
            Date date = new Date(time);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 如果时间是今天内的，输出格式：今天 HH:mm
     * 其他日期，输出格式：MM-dd HH:mm
     * 其他年份，输出格式：yyyy-MM-dd HH:mm
     * @param time
     * @param todayTextFormat
     * @return
     */
    public static String formatWithToday(long time, String todayTextFormat){
        Calendar target = Calendar.getInstance();
        target.setTimeInMillis(time);
        Calendar curr = Calendar.getInstance();
        if (curr.get(Calendar.YEAR) == target.get(Calendar.YEAR)){
            if(curr.get(Calendar.DAY_OF_YEAR) == target.get(Calendar.DAY_OF_YEAR)){
                return String.format(todayTextFormat, String.format("%02d:%02d", target.get(Calendar.HOUR_OF_DAY),
                        target.get(Calendar.MINUTE)));
            }else{
                return formatQuickly("MM-dd HH:mm", time);
            }
        } else{
            return formatQuickly("yyyy-MM-dd HH:mm", time);
        }
    }

    public static String formatDayWithThisYear(long time, String thisYearFormat, String otherYearFormat){
        int result = compareYear(time, System.currentTimeMillis());
        return formatQuickly(result == 0 ? thisYearFormat : otherYearFormat, time);
    }



}
