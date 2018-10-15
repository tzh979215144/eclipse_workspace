package org.zhoukan.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyDate {

	public static String getDate(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(Calendar.getInstance().getTime());
	}
	
	public static String getTime(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(Calendar.getInstance().getTime());
	}
}
