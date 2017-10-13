package club.wokao666.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

	public static final long TimeMillisOneSecond = 1000;
	public static final long TimeMillisThreeSecond = 3 * 1000;
	public static final long TimeMillisFiveSecond = 5 * 1000;
	public static final long TimeMillisFifteenSecond = 15 * 1000;

	public static final long TimeMillisOneDay = 24 * 60 * 60 * 1000;
	public static final int TimeMillisOneDayInt = 24 * 60 * 60 * 1000;
	public static final long TimeMillisOneHour = 60 * 60 * 1000;
	public static final long TimeMillisTwoHour = 2 * 60 * 60 * 1000;
	public static final long TimeMillisOneMinute = 60 * 1000;
	public static final long TimeMillis30Minute = 30 * 60 * 1000;
	public static final long TimeMillisThreeMinute = 3 * 60 * 1000;
	public static final long TimeMillisFiveMinute = 5 * 60 * 1000;
	public static final long TimeMillisSixMinute = 6 * 60 * 1000;
	public static final long TimeMillisHalfMinute = 30 * 1000;
	public static final int TimeMillisFiftyMinute = 50 * 60 * 1000;
	public static final int TimeMillisTwentyMinute = 20 * 60 * 1000;

	public static final int SecondsOneDay = 24 * 60 * 60;
	public static final int SecondsTwoDay = 48 * 60 * 60;
	public static final int SecondsThreeDay = 72 * 60 * 60;
	

	public static final int SecondsHalfDay = 12 * 60 * 60;
	public static final int SecondsEightHour = 8 * 60 * 60;

	public static final int SecondsOneMinute = 60;
	public static final int SecondsTwoMinute = 2 * 60;
	public static final int SecondsFiveMinute = 5 * 60;
	public static final int SecondsSixMinute = 6 * 60;
	public static final int SecondsTenMinute = 10 * 60;
	public static final int SecondsFifteenMinute = 15 * 60;
	public static final int SecondsHalfHour = 30 * 60;
	public static final int SecondsOneHour = 1 * 60 * 60;
	public static final int SecondsTwoHour = 2 * 60 * 60;
	public static final int SecondsThreeHour = 3 * 60 * 60;
	public static final int SecondsThreeAndHalfHour = 3 * 60 * 60 + 30 * 60;
	public static final int SecondsFourHour = 4 * 60 * 60;
	public static final int SecondsFourAndHalfHour = 4 * 60 * 60 + 30 * 60;
	public static final int SecondsFiveHour = 5 * 60 * 60;
	public static final int SecondsSixHour = 6 * 60 * 60;

	public static final int SecondsSevenDay = 7 * 24 * 60 * 60;
	public static final int SecondsEightDay = 8 * 24 * 60 * 60;

	private String formatPatten;

	private ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(formatPatten);
		}
	};

	/**
	 * 获取当前微秒时间
	 * 
	 * @return
	 */
	public final static long getCurrentMillisTime() {
		return System.currentTimeMillis();
	}

	public final static long getCurrentMillisTimeInMinute() {
		return System.currentTimeMillis() / 60000 * 60000;
	}

	/**
	 * 获得当前时间戳, 时间戳是自 1970 年 1 月 1 日（00:00:00 GMT）以来的秒数。 是一个整型数值。
	 * 
	 * @return
	 */
	public final static int timestamp() {
		return (int) (System.currentTimeMillis() / 1000);
	}

	/**
	 * 获了零点时间戳
	 * 
	 * @return integer
	 */
	public final static int getMorningTime() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return (int) (cal.getTimeInMillis() / 1000);
	}

	/**
	 * 获了零点时间戳
	 * 
	 * @return integer
	 */
	public final static long getMorningTimeMillis() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}

	public final static long getMidnightTimeMillis() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTimeInMillis();
	}

	/**
	 * 获得第二天零点时间戳
	 * 
	 * @return
	 */
	public final static int getTomorrowMorningTime() {
		return getMorningTime() + SecondsOneDay;
	}

	/**
	 * 获得第二天零点时间戳
	 * 
	 * @return
	 */
	public final static int getTomorrowMorningTime(int timestamp) {
		return getMorningTime(timestamp) + SecondsOneDay;
	}

	/**
	 * 获取当前时间的零点时间
	 * 
	 * @param timestamp
	 * @return
	 */
	public final static long getMorningTimeMillis(long timestamp) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timestamp);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}

	/**
	 * 获取当前时间的零点时间
	 * 
	 * @param timestamp
	 * @return
	 */
	public final static int getMorningTime(int timestamp) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timestamp * 1000L);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return (int) (cal.getTimeInMillis() / 1000);
	}

	/**
	 * 获取当前月开始时间
	 * 
	 * @return
	 */
	public final static int getMonthStartTime() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return (int) (cal.getTimeInMillis() / 1000);
	}

	/**
	 * 获取当前月天数
	 * 
	 * @return
	 */
	public final static int getCurMonthDayNum() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		cal.roll(Calendar.DATE, -1);
		return cal.get(Calendar.DATE);
	}

	/**
	 * 获取当前是一个月中的第几天
	 * 
	 * @return
	 */
	public final static int getDayOfMonth() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.DATE);
	}

	/**
	 * 获取当前月份
	 * 
	 * @return
	 */
	public final static int getMonth() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取当前小时数
	 * 
	 * @return
	 */
	public final static int getDayOfHour() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 获取当前几点几分
	 * 
	 * @return
	 */
	public final static String getTimeOfDay() {
		Calendar cal = Calendar.getInstance();
		int m = cal.get(Calendar.MINUTE);
		String temp = m < 10 ? "0" + m : m + "";
		return cal.get(Calendar.HOUR_OF_DAY) + ":" + temp;
	}

	/**
	 * 获取指定时间的月天数
	 * 
	 * @return
	 */
	public final static int getMonthDayNum(Long millis) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(millis);
		cal.set(Calendar.DATE, 1);
		cal.roll(Calendar.DATE, -1);
		return cal.get(Calendar.DATE);
	}

	/**
	 * 获得当前时间，“yyyy-MM-dd HH:mm:ss”格式
	 */
	public final static String getCurrTimeFormat() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 获取某个时间戳的“yyyy-MM-dd”格式
	 */
	public final static String getTimeFormat(int time) {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date(time * 1000L));
	}

	/**
	 * 获取某个时间戳的“yyyy-MM-dd”格式
	 */
	public final static String getTimeFormatDay() {
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}

	/**
	 * 获取某个时间戳的“MM-dd”格式
	 */
	public final static String getTimeFormatMMdd(long time) {
		return new SimpleDateFormat("MM-dd").format(new Date(time * 1000L));
	}
	
	/**
	 * 获得当前时间的某个时间量，如想获得小时，则 format = "HH", 年份（“yyyy”）
	 */
	public final static int getCurrTimeOneFormat(String formatStr) {
		String time = new SimpleDateFormat(formatStr).format(new Date());
		return Integer.parseInt(time);
	}

	public TimeUtils(String formatPatten) {
		this.formatPatten = formatPatten;
	}

	public String format(Date d) {
		return sdf.get().format(d);
	}

	public String formatCurrentDate() {
		return format(new Date());
	}

	public Date parse(String dateStr) {
		try {
			return sdf.get().parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param timeMillis
	 * @return
	 */
	public String format(long timeMillis) {
		return format(new Date(timeMillis));
	}

	/**
	 * 判断两个时间是否同一天
	 * 
	 * @param timeMillis
	 * @return
	 */
	public static boolean isSameDay(long timeMillis) {
		Calendar calendarBegin = Calendar.getInstance();
		calendarBegin.setTimeInMillis(timeMillis);
		return isSameDay(calendarBegin, Calendar.getInstance());
	}

	/**
	 * 判断两个时间是否同一天
	 * 
	 * @param times
	 * @return
	 */
	public static boolean isSameDay(int times) {
		long timess = times;
		return isSameDay(timess * 1000);
	}

	/**
	 * 判断两个时间是否同一天
	 * 
	 * @param timeMillis1
	 * @param timeMillis2
	 * @return
	 */
	public static boolean isSameDay(long timeMillis1, long timeMillis2) {
		Calendar calendarBegin = Calendar.getInstance();
		calendarBegin.setTimeInMillis(timeMillis1);
		Calendar calendarNow = Calendar.getInstance();
		calendarNow.setTimeInMillis(timeMillis2);
		return isSameDay(calendarBegin, calendarNow);
	}

	/**
	 * 判断两个时间是否同一天
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static boolean isSameDay(int time1, int time2) {
		return isSameDay(time1 * 1000L, time2 * 1000L);
	}

	/**
	 * 判断是不是同一天
	 * 
	 * @param calendarBegin
	 * @param calendarNow
	 * @return
	 */
	private static boolean isSameDay(Calendar calendarBegin, Calendar calendarNow) {
		return (calendarBegin.get(Calendar.YEAR) == calendarNow.get(Calendar.YEAR))
				&& (calendarBegin.get(Calendar.MONTH) == calendarNow.get(Calendar.MONTH))
				&& (calendarBegin.get(Calendar.DATE) == calendarNow.get(Calendar.DATE));
	}

	/**
	 * 判断是否同一月份
	 * 
	 * @param timeMillis1
	 * @param timeMillis2
	 * @return
	 */
	public static boolean isSameMonth(long timeMillis1, long timeMillis2) {
		Calendar calendarBegin = Calendar.getInstance();
		calendarBegin.setTimeInMillis(timeMillis1);
		Calendar calendarNow = Calendar.getInstance();
		calendarNow.setTimeInMillis(timeMillis2);
		if ((calendarBegin.get(Calendar.YEAR) == calendarNow.get(Calendar.YEAR))
				&& (calendarBegin.get(Calendar.MONTH) == calendarNow.get(Calendar.MONTH))) {
			return true;
		}
		return false;
	}

	/**
	 * 获取当前是周几(周日是1，周一是2)
	 * 
	 * @return
	 */
	public static int getDayOfWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(TimeUtils.getCurrentMillisTime());
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 获取当前是周几（周日是7，周一是1）
	 * 
	 * @return
	 */
	public static int getDayOfWeek2() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(TimeUtils.getCurrentMillisTime());
		int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return day == 0 ? 7 : day;
	}

	public static boolean isSameDayOnTimestamp(int timestamp) {
		return isSameDay(timestamp * 1000L);
	}

	public static boolean isBeforeNow(long timeMillis) {
		return timeMillis < System.currentTimeMillis();
	}

	public static boolean isAfterNow(long timeMillis) {
		return timeMillis > System.currentTimeMillis();
	}

	public static long extendTimeSeconds(int duration) {
		return System.currentTimeMillis() + duration * 1000;
	}

	public static long extendTimeMillis(long extend) {
		return extendTimeMillis(System.currentTimeMillis(), extend);
	}

	/**
	 * 向后延长时间
	 * 
	 * @param timeMills
	 *            基础毫秒数
	 * @param extend
	 *            延长的毫秒数
	 * @return
	 */
	public static long extendTimeMillis(long timeMills, long extend) {
		return timeMills + extend;
	}

	/**
	 * 向后延长时间
	 * 
	 * @param timeMills
	 *            基础毫秒数
	 * @param extend
	 *            延长的秒数
	 * @return
	 */
	public static long extendTimeSeconds(long timeMills, int extend) {
		return timeMills + (extend * 1000L);
	}

	public static long diffTimeMillis(long t1, long t2) {
		return t1 - t2;
	}

	/**
	 * t1减去当前时间后的毫秒数
	 * 
	 * @param t1
	 * @return
	 */
	public static long diffNow(long t1) {
		return diffTimeMillis(t1, TimeUtils.getCurrentMillisTime());
	}

	/**
	 * 当前时间减去t1后的毫秒数
	 * 
	 * @param t1
	 * @return
	 */
	public static long diffByNow(long t1) {
		return diffTimeMillis(TimeUtils.getCurrentMillisTime(), t1);
	}

	/**
	 * 值减去当前毫秒数
	 * 
	 * @param t
	 * @return
	 */
	public static long subNow(long t) {
		return t - System.currentTimeMillis();
	}

	/**
	 * 当前毫秒数减去值
	 * 
	 * @param t
	 * @return
	 */
	public static long subByNow(long t) {
		return System.currentTimeMillis() - t;
	}

	/**
	 * 将时间字符串转换为时间戳
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static int getTimestampByString(String date, String format) {
		try {
			Date d = new SimpleDateFormat(format).parse(date);
			return (int) (d.getTime() / 1000);
		} catch (ParseException e) {
			return 0;
		}
	}

	/**
	 * 将时间字符串转换为时间戳
	 * 
	 * @param date
	 * @return
	 */
	public final static int getTimestampByString(String date) {
		return getTimestampByString(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取时间的时、天、月份等
	 * 
	 * @param calendarType
	 * @return
	 */
	public final static int getTimeByType(long time, int calendarType) {
		Date date = new Date(time);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(calendarType);
	}

	/**
	 * 根据 HH:mm 获得时间戳
	 * 
	 * @return
	 */
	public final static int getTimestampByHHmm(String str) {
		String prefix = getDateString("yyyy-MM-dd");
		return getTimestampByString(String.format("%s %s:00", prefix, str.trim()));
	}

	/**
	 * 根据 HH:mm:ss 获得时间戳
	 * 
	 * @return
	 */
	public final static int getTimestampByHHmmss(String str) {
		String prefix = getDateString("yyyy-MM-dd");
		return getTimestampByString(String.format("%s %s", prefix, str.trim()));
	}

	/**
	 * 根据 HH:mm:ss 获得秒数
	 * 
	 * @return
	 */
	public final static int getSecondsByHHmmss(String str) {
		String prefix = getDateString("yyyy-MM-dd");
		int temp = getTimestampByString(String.format("%s %s", prefix, str.trim()));
		return temp - getMorningTime();
	}

	/**
	 * 获取当前时间
	 * 
	 * @param format
	 * @return
	 */
	public static String getDateString(String format) {
		Date date = new Date();
		SimpleDateFormat mat = new SimpleDateFormat(format);
		return mat.format(date);
	}

	/**
	 * 当前时间到当天凌晨的秒数差
	 * 
	 * @return
	 */
	public static int getDiffSecondsFormMidnight() {
		return getDiffSecondsFormMidnight(Calendar.getInstance());
	}

	/**
	 * 获取时间到当天凌晨的秒数差
	 * 
	 * @param calendar
	 * @return
	 */
	public static int getDiffSecondsFormMidnight(Calendar calendar) {
		Calendar midnight = Calendar.getInstance();
		midnight.set(Calendar.HOUR_OF_DAY, 0);
		midnight.set(Calendar.MINUTE, 0);
		midnight.set(Calendar.SECOND, 0);
		return getDiffSeconds(calendar, midnight);
	}

	/**
	 * 计算两个时间之间的秒数差
	 * 
	 * @param calendar1
	 * @param calendar2
	 * @return
	 */
	public static int getDiffSeconds(Calendar calendar1, Calendar calendar2) {
		return (int) (calendar1.getTimeInMillis() - calendar2.getTimeInMillis()) / 1000;
	}

	/**
	 * 将时间戳以指定格式输出为本地时间字符串
	 * 
	 * @param timestamp
	 * @return
	 */
	public final static String toTime(int timestamp, String format) {
		return toTime((long) (timestamp * 1000L), format);
	}

	/**
	 * 将微秒以指定格式输出为本地时间字符串
	 * 
	 * @param millis
	 * @param format
	 * @return
	 */
	public static String toTime(long millis, String format) {
		Date date = new Date(millis);
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}

	public static int millis2seconds(long time) {
		return (int) (time / 1000);
	}

	/**
	 * 向上取整
	 * */
	public static int millis2Minutes(long time) {
		return (int) Math.ceil((time / 1000 / 60));
	}

	public static int[] getDateBefore(int day) {
		int[] daynum = new int[day];
		long curdate = System.currentTimeMillis();
		for (int i = 1; i <= day; i++) {
			Calendar now = Calendar.getInstance();
			now.set(Calendar.DATE, now.get(Calendar.DATE) - i);
			if (isSameMonth(curdate, now.getTimeInMillis())) {
				// 判断这一时间是否为当月
				daynum[i - 1] = now.get(Calendar.DAY_OF_MONTH);
			}
		}
		return daynum;
	}

	public static boolean checkDateBefore(int checkday, int day) {
		int[] days = TimeUtils.getDateBefore(checkday);
		for (int i = 0; i < days.length; i++) {
			if (day == days[i]) {
				return true;
			}
		}
		return false;
	}

	/** 五点服务器刷新 */
	public static final int ServerRefresh5 = 5;
	public static final int ServerRefresh0 = 0;
	public static final int ServerRefresh18 = 18;

	/**
	 * 根据传入的时间得到服务器下次更新的时间 大于五点的话，第二天的五点.小于五点的话，当天的五点
	 * 
	 * @param timeMills
	 * @return
	 */
	public static Calendar getServerNextRefreshDate(long timeMills) {
		return getNextRefreshDateByHour(timeMills, ServerRefresh5);
	}

	public static Calendar getServerNextRefreshZeroDate(long timeMills) {
		return getNextRefreshDateByHour(timeMills, ServerRefresh0);
	}

	public static Calendar getServerNextRefreshPMSixDate(long timeMills) {
		return getNextRefreshDateByHour(timeMills, ServerRefresh18);
	}

	public static Calendar getServerRefreshFiveDate(long timeMills) {
		return getRefreshDateByHour(timeMills, ServerRefresh5);
	}

	public static Calendar getServerRefreshZeroDate(long timeMills) {
		return getRefreshDateByHour(timeMills, ServerRefresh0);
	}

	public static Calendar getServerRefreshPMSixDate(long timeMills) {
		return getRefreshDateByHour(timeMills, ServerRefresh18);
	}

	/**
	 * 根据传入的时间得到服务器下次更新的时间 大于hour点的话取第二天的hour点；小于hour点的话，当天的hour点
	 * 
	 * @param timeMills
	 * @return hour 指定的小时数
	 */
	public static Calendar getNextRefreshDateByHour(long timeMills, int hour) {
		Calendar serverCal = Calendar.getInstance();
		serverCal.setTimeInMillis(timeMills);
		int currentHour = serverCal.get(Calendar.HOUR_OF_DAY);
		boolean isNextDay = currentHour >= hour;
		int newDay = isNextDay ? serverCal.get(Calendar.DAY_OF_MONTH) + 1 : serverCal.get(Calendar.DAY_OF_MONTH);
		serverCal.set(serverCal.get(Calendar.YEAR), serverCal.get(Calendar.MONTH), newDay, hour, 0, 0);
		serverCal.set(Calendar.MILLISECOND, 0);
		return serverCal;
	}

	/**
	 * 根据传入的时间得到服务器下次更新的时间 大于hour点的话取当天的hour点；小于hour点的话，前一天的hour点
	 * 
	 * @param timeMills
	 * @return hour 指定的小时数
	 */
	public static Calendar getRefreshDateByHour(long timeMills, int hour) {
		Calendar serverCal = Calendar.getInstance();
		serverCal.setTimeInMillis(timeMills);
		int currentHour = serverCal.get(Calendar.HOUR_OF_DAY);
		boolean isNextDay = currentHour >= hour;
		int newDay = isNextDay ? serverCal.get(Calendar.DAY_OF_MONTH) : serverCal.get(Calendar.DAY_OF_MONTH) - 1;
		serverCal.set(serverCal.get(Calendar.YEAR), serverCal.get(Calendar.MONTH), newDay, hour, 0, 0);
		serverCal.set(Calendar.MILLISECOND, 0);
		return serverCal;
	}

	public static void test(){
		Calendar cal =  getRefreshDateByHour(System.currentTimeMillis(), 5);
		System.err.println(cal.getTime());
	}
	
	/**
	 * 根据传入的时间得到服务器得到第二天的hour点
	 */
	public static Calendar getNextDayHour(long timeMills, int hour) {
		Calendar serverCal = Calendar.getInstance();
		serverCal.setTimeInMillis(timeMills);
		int newDay = serverCal.get(Calendar.DAY_OF_MONTH) + 1;
		serverCal.set(serverCal.get(Calendar.YEAR), serverCal.get(Calendar.MONTH), newDay, hour, 0, 0);
		serverCal.set(Calendar.MILLISECOND, 0);
		return serverCal;
	}

	/**
	 * 判断两个时间戳（毫秒）是否是在同个服务器天内---服务器每天五点分割前后两天
	 * 
	 * @param timeMillis1
	 * @param timeMillis2
	 * @return
	 */
	public static boolean isSameServerDay(long timeMillis1, long timeMillis2) {
		if (timeMillis2 == timeMillis1) {
			return true;
		} else if (timeMillis2 > timeMillis1) {
			Calendar cal = getServerNextRefreshDate(timeMillis1);
			return timeMillis2 < cal.getTimeInMillis();
		} else {
			Calendar cal = getServerNextRefreshDate(timeMillis2);
			return timeMillis1 < cal.getTimeInMillis();
		}
	}

	/**
	 * 判断两个时间戳（秒）是否是在同个服务器天内---服务器每天五点分割前后两天
	 * 
	 * @param timestamp
	 *            当前实际戳
	 * @param now
	 *            当前时间
	 * @return
	 */
	public static boolean isSameServerDayOnTimestamp(int timestamp, int now) {
		return isSameServerDay(timestamp * 1000L, now * 1000L);
	}

	/**
	 * 获取当前月份有多少天
	 * @return
	 */
	public static int getDaysThisMonth() {
		Calendar now = Calendar.getInstance();
		return now.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 根据相隔的秒数获得 --- 多少天多少小时多少分多少秒
	 * 
	 * @param time
	 */
	public static String getDetailDateFromSecond(int time) {
		if (time <= 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		// 天数
		if (time / SecondsOneDay > 0) {
			sb.append((time / SecondsOneDay) + "天");
			time = time - (time / SecondsOneDay) * SecondsOneDay;
		}
		// 小时数
		if (time / SecondsOneHour > 0) {
			sb.append((time / SecondsOneHour) + "小时");
			time = time - (time / SecondsOneHour) * SecondsOneHour;
		}
		// 分数
		if (time / SecondsOneMinute > 0) {
			sb.append((time / SecondsOneMinute) + "分");
			time = time - (time / SecondsOneMinute) * SecondsOneMinute;
		}
		// 秒数
		if (time > 0) {
			sb.append(time + "秒");
		}
		return sb.toString();
	}

	/**
	 * 根据传入的时间得到服务器下次更新的时间 大于hour点的话取当天的hour点；小于hour点的话，前一天的hour点
	 * 
	 * @param timeMills
	 * @return hour 指定的小时数
	 */
	public static Calendar getFirstDateByHour(long timeMills, int hour) {
		Calendar serverCal = Calendar.getInstance();
		serverCal.setTimeInMillis(timeMills);
		int currentHour = serverCal.get(Calendar.HOUR_OF_DAY);
		boolean isPreDay = currentHour < hour;
		int newDay = isPreDay ? serverCal.get(Calendar.DAY_OF_MONTH) - 1 : serverCal.get(Calendar.DAY_OF_MONTH);
		serverCal.set(serverCal.get(Calendar.YEAR), serverCal.get(Calendar.MONTH), newDay, hour, 0, 0);
		serverCal.set(Calendar.MILLISECOND, 0);
		return serverCal;
	}
	
	public static Calendar getServerPreFiveDate(long timeMills) {
		return getFirstDateByHour(timeMills, ServerRefresh5);
	}
	
	public static void main1(String[] args) throws ParseException {
		// 1446693577 2015/11/5 11:19:37 - 1446591531 2015/11/4 6:58:51
		System.out.println(getDetailDateFromSecond(1446693577 - 1446591531));
		System.out.println(getDetailDateFromSecond(timestamp() - 1446393600));
		// String time = "2015-06-08 04:59:00";
		// SimpleDateFormat format = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// int oldTime = (int) (format.parse(time).getTime()/1000);
		// // boolean a = isSameServerDayOnTimestamp(oldTime, timestamp());
		// int a = (timestamp() - oldTime)/SecondsOneDay;
		// System.out.println(a);

		Calendar cl = getServerNextRefreshZeroDate(System.currentTimeMillis());
		Calendar c2 = getServerRefreshZeroDate(System.currentTimeMillis());
		// boolean bb = checkDateBefore(3,21);
		System.out.println(cl.getTime());
		System.out.println(c2.getTime());

		// String hhmmss = "1:50:05";
		// int a = getSecondsByHHmmss(hhmmss);
		// System.out.println(a);
		//
		// Date d = new Date(2015 -1900, 0, 29, 11, 1);
		// Date d5 = new Date(2015 -1900, 0, 29, 5, 1);
		// Date d1 = new Date(2015 -1900, 0, 29, 4, 1);
		// Date d2 = new Date(2015 -1900, 0, 29, 5, 0);
		// Date d3 = new Date(2015 -1900, 0, 28, 5, 0);
		// Date d4 = new Date(2015 -1900, 0, 30, 5, 0);
		// Date d6 = new Date(2015 -1900, 0, 30, 4, 59);
		// // print(d1,d);
		// print(d5,d);
		// print(d,d5);
		// // print(d2,d);
		// // print(d1,d2);
		// // print(d3,d2);
		// // print(d2,d4);
		// // print(d2,d6);
	}

	public static int getYesterday() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return (int) (cal.getTimeInMillis() / 1000);
	}

	/** 获取上周的周数,周一分界 */
	public static int getLastWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.WEEK_OF_YEAR, -1);
		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			calendar.add(Calendar.WEEK_OF_YEAR, -1);
		}
		int week = calendar.get(Calendar.WEEK_OF_YEAR);
		return week;
	}
	
	/** 获取上一小时的时间区间
	 * @return 比如现在是11:34  返回是：【0】：10:00，【1】：11:00
	 */
	public static int[] getHoursTimes() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR_OF_DAY, -1);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		int min = (int) (calendar.getTimeInMillis() / 1000L);
		calendar.add(Calendar.HOUR_OF_DAY, 1);
		calendar.add(Calendar.SECOND, -1);
		int max = (int) (calendar.getTimeInMillis() / 1000L);
		int[] result = new int[2];
		result[0] = min;
		result[1] = max;
		return result;
	}
	
	/** 获取上一天的时间区间
	 * @return 比如现在是2016-02-17 14:40  返回是：[0]: 2016-02-16 00:00:00，【1】：2016-02-17 00:00:00
	 */
	public static int[] getDayTimes() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		int min = (int) (calendar.getTimeInMillis() / 1000L);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		calendar.add(Calendar.SECOND, -1);
		int max = (int) (calendar.getTimeInMillis() / 1000L);
		int[] result = new int[2];
		result[0] = min;
		result[1] = max;
		return result;
	}

	/** 获取上月的时间区间
	 */
	public static int[] getLastMonthTimes() {
		//获取前月的第一天
		Calendar   cal_1=Calendar.getInstance();//获取当前日期
		cal_1.add(Calendar.MONTH, -1);
		cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
		cal_1.set(Calendar.HOUR_OF_DAY, 0);
		cal_1.set(Calendar.MINUTE, 0);
		cal_1.set(Calendar.SECOND, 0);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		int min = (int) (cal_1.getTimeInMillis() / 1000L);
		int max = (int) (c.getTimeInMillis() / 1000L);
		int[] result = new int[2];
		result[0] = min;
		result[1] = max;
		return result;
	}


	public static void print(Date d, Date d1) {
		System.err.println(d.toLocaleString() + " and " + d1.toLocaleString() + " is "
				+ (isSameServerDay(d.getTime(), d1.getTime()) ? "" : " not ") + " same day.");
	}
	
	/**
	 * 
	 * 根据两个时间是否相邻在指定天数内
	 * @param one 秒数
	 * @param two 秒数
	 * @param days
	 * @return true 在指定天数内，false-不在
	 */
	public static boolean isInDaysBetweenTwoTime(int one,int two,int days){
		int sub = Math.abs(one - two);
		return sub <= SecondsOneDay*days;
	}

	/**
	 * 
	 * 获得hour小时整点的毫秒数
	 * @param hour
	 * @param hour
	 * @return
	 */
	public static long getNextTimeByHour(int hour){
		Calendar calendar = Calendar.getInstance();
		int curDay = calendar.get(Calendar.DATE);
		calendar.set(Calendar.DATE, curDay + (hour / 24));
		calendar.set(Calendar.HOUR_OF_DAY, hour % 24);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTimeInMillis();
	}
	public static void main(String[] args) {
		int curday24 = TimeUtils.getMorningTime(TimeUtils.timestamp());
		int yesday24 = curday24 - 86400; //昨天
		int towday24 = curday24 + 86400; //今天
		System.err.println("sss="+yesday24+"  "+towday24);
	}



}
