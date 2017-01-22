# DateUtil &  网络工具类

#### 类名：DateUtil

| name        | void name           | direction  |
| ------------- | ------------- | :-----:|
| 获取传入时间的对应时间long值      | long getTimeLong(Calendar calendar) | |
| 根据类型获取传入时间calendar的对应字符串      |  String getTimeString(Calendar calendar, int type)      |  |
| 将long类型时间转为对应type的字符串 | String getTimeString(long millis, int type) |    |
| 将Date类型时间转为对应type的字符串   |  String getTimeString(Date date, int type)   |
| 根据类型获取传入字符串的时间 、-1为当前时间      | Calendar getTimeCalendar(String date, int type) | |
| 将一格式字符串转为另一格式字符串      | String transformTimeString(String date, int newtype,int oldtype) |  date   转换前时间字符串  newtype 转换后格式 oldtype 转换前格式  |
| 根据类型比较agodate与afterdate时间前后 | int compareTime(String agodate, String afterdate, int type) |      * @param agodate   时间1 <br> @param agotype   时间1类型 <br> @param afterdate 时间2 <BR> @param aftertype 时间2类型 <br> @return 0为相等、1为agodate前、-1为afterdate前  |
| 根据类型比较agodate与afterdate时间前后： |  int compareTime(String agodate, int agotype,String afterdate, int aftertype)   |
| 周几  | int getOurWeek(Calendar calendar) |  周一返回 1；周日返回 7  |
| 根据1`7获取对应的星期 | String getWeek(Context context, int week) |     |
| 两个时间是否是同一周 |  boolean isSameWeek(String date1, String date2) |
| 两个时间是否是同一周  | boolean isSameWeek(String date1, String date2, int type) |
| 聊天时间 | String formatWithToday(long time, String todayTextFormat) |  如果时间是今天内的，输出格式：今天 HH:mm <br>其他日期，输出格式：MM-dd HH:mm<br>其他年份，输出格式：yyyy-MM-dd HH:mm   |

####说明
日期类型

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

#Contact me

E-mail:wenld2014@163.com

blog: [wenld's blog](http://blog.csdn.net/sinat_15877283)
