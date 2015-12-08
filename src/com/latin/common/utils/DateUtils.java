package com.latin.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类，不断更新中...
 * 
 * @author nick
 * @since 2015/09/10
 * @version 1.0
 */
public class DateUtils {

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 构造函数
	 */
	public DateUtils() {

	}
	
	public static String getDefaultFormatCurrentDate() {
		return getFormatCurrentDate(YYYY_MM_DD_HH_MM_SS);
	}

	public static String getFormatCurrentDate(String pattern) {
		return format(new Date(), pattern);
	}
	
	public static String format(Date date, String pattern) {
		return getFormatter(pattern).format(date);
	}

	private static SimpleDateFormat getFormatter(String parttern) {
		return new SimpleDateFormat(parttern);
	}

}
