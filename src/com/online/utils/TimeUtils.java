package com.online.utils;

import java.util.Calendar;
/**
 * 时间工具类
 * @author Administrator
 *
 */
public class TimeUtils {
	/**
	 * 获取到当前时间的字符串类型信息
	 * 
	 * @return
	 */
	public static String getCurrentDateTime() {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int date = c.get(Calendar.DATE);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		return year + "年" + month + "月" + date + "日" + hour + "时" + minute + "分" + second + "秒";
	}
}
