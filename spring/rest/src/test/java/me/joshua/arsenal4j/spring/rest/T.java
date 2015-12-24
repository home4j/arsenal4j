package me.joshua.arsenal4j.spring.rest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class T {
	public static void main(String[] args) throws Throwable {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date d = sdf.parse("02:32");
		System.out.println(d);
		System.out.println(d.getTime() % DateUtils.MILLIS_PER_DAY);
	}
}
