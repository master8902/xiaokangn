package com.xiaolangn.bean;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal = Calendar.getInstance();

	public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}

	public Date getStringToDate(String s) {
		ParsePosition pos = new ParsePosition(0);
		Date d = df.parse(s, pos);
		return d;
	}

	public Date getStringToDate2(String s) {
		ParsePosition pos = new ParsePosition(0);
		Date d = df2.parse(s, pos);
		return d;
	}

	public long getLastTimeInMillis(Calendar c, int h, int m, int s) {
		cal.setTimeInMillis(c.getTimeInMillis() - 24 * 60 * 60 * 1000);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DATE), h, m, s);
		return cal.getTimeInMillis();
	}

	public long getCurrentTimeInMillis(Calendar c, int h, int m, int s) {
		cal.setTimeInMillis(c.getTimeInMillis());
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DATE), h, m, s);
		return cal.getTimeInMillis();
	}

	public long getCurrentTimeInMillis(Date d, int h, int m, int s) {
		cal.setTime(d);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DATE), h, m, s);
		return cal.getTimeInMillis();
	}

	public String getCurrentTime(Calendar c, int h, int m, int s) {
		cal.setTimeInMillis(c.getTimeInMillis());
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DATE), h, m, s);
		return df.format(cal.getTime());
	}

	public String getCurrentTime(Date d, int h, int m, int s) {
		cal.setTime(d);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DATE), h, m, s);
		return df.format(cal.getTime());
	}

	public String getCurrentTime(Calendar c) {
		return df.format(c.getTime());
	}

	public String getCurrentTime2(Calendar c) {
		return df2.format(c.getTime());
	}

	public String getCurrentTime(Date cal) {
		return df.format(cal);
	}

	public String getCurrentTime2(Date cal) {
		return df2.format(cal);
	}

	public String getCurrentTime() {
		return df.format(cal.getTime());
	}

	public String getCurrentTime2() {
		return df2.format(cal.getTime());
	}

	public long getCurrentTimeInMillis(Date d) {
		cal.setTime(d);
		return cal.getTimeInMillis();
	}

	public long getCurrentTimeInMillis(String s) {
		Date d = this.getStringToDate(s);
		return this.getCurrentTimeInMillis(d);
	}

	public String getLastNTime(Calendar c, int h, int m, int s, int d) {
		cal.setTimeInMillis(c.getTimeInMillis() - d * 24 * 60 * 60 * 1000);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DATE), h, m, s);
		return df.format(cal.getTime());
	}

	public String getLastNTime(Date date, int h, int m, int s, int d) {
		cal.setTime(date);
		cal.setTimeInMillis(cal.getTimeInMillis() - d * 24 * 60 * 60 * 1000);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DATE), h, m, s);
		return df.format(cal.getTime());
	}

	public String getLastNTime_Min(Calendar c, int s, int d) {
		cal.setTimeInMillis(c.getTimeInMillis() - d * 60 * 1000);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DATE), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), s);
		return df.format(cal.getTime());
	}

	public long getLastNTime_MinInMillis(Calendar c, int s, int d) {
		cal.setTimeInMillis(c.getTimeInMillis() - d * 60 * 1000);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DATE), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), s);
		return cal.getTimeInMillis();
	}

	public long getLastNTime_HourInMillis(Calendar c, int d) {
		cal.setTimeInMillis(c.getTimeInMillis() - d * 60 * 60 * 1000);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DATE), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
		return cal.getTimeInMillis();
	}

	public long getLastNTime_MinuteMillis(Calendar c, int d) {
		cal.setTimeInMillis(c.getTimeInMillis() - 1 * d * 60 * 1000);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DATE), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
		return cal.getTimeInMillis();
	}

	public long getLastNTime_HourInMillis(String s, int d) {
		Date da = this.getStringToDate(s);
		cal = Calendar.getInstance();
		cal.setTime(da);
		cal.setTimeInMillis(cal.getTimeInMillis() - d * 60 * 60 * 1000);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DATE), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
		return cal.getTimeInMillis();
	}

	public String getLastNTime_Hour(Calendar c, int d) {
		cal.setTimeInMillis(c.getTimeInMillis() - d * 60 * 60 * 1000);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DATE), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
		return df.format(cal.getTime());
	}

	public long getLastNTimeInMillis(Calendar c, int h, int m, int s, int d) {
		cal.setTimeInMillis(c.getTimeInMillis() - d * 24 * 60 * 60 * 1000);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DATE), h, m, s);
		return cal.getTimeInMillis();
	}

	public long getLastNTimeInMillis(Date date, int h, int m, int s, int d) {
		cal = Calendar.getInstance();
		cal.setTime(date);
		cal.setTimeInMillis(cal.getTimeInMillis() - d * 24 * 60 * 60 * 1000);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DATE), h, m, s);
		return cal.getTimeInMillis();
	}

	public static void main(String[] args) {
		DateUtil d = new DateUtil();
		/*
		 * for (int i = 0; i < 100; i++) {
		 * System.out.println(d.getCurrentTime()); try { new
		 * Thread().sleep(6000); } catch (InterruptedException e) {
		 * e.printStackTrace(); } }
		 */
		System.out.println("123--" + Integer.parseInt(""));

	}
}

// /----
