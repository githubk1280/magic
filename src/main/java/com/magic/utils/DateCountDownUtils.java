package com.magic.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateCountDownUtils {
	public static String countDown(int year, int month, int date, int count) {
		Calendar c = Calendar.getInstance();
//		System.out.println(year+"-"+month+"-"+date+":"+count);
		c.set(year, month, date);
		c.add(Calendar.DAY_OF_YEAR, count);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String d = sdf.format(c.getTime());
		System.out.println("countDown ="+d);
		return d;
	}

	public static Calendar getStartDate() {
		Calendar c = Calendar.getInstance();
		c.set(2012, 11, 1);
		return c;
	}

	public static void main(String args[]) {
		Calendar start = getStartDate();
//		System.out.println(start);
		for (int i = 0; i < 50; i++) {
			System.out.println(countDown(start.get(Calendar.YEAR),
					start.get(Calendar.MONTH), start.get(Calendar.DAY_OF_MONTH),
					i));
		}
	}
}
