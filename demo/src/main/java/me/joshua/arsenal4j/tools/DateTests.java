package me.joshua.arsenal4j.tools;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

public class DateTests {
	public static void main(String[] args) throws Throwable {
		FastDateFormat format = FastDateFormat.getInstance("yyyyMMdd");
		Date s = format.parse("20121211");
		Date e = format.parse("20130111");
		int i = (int) ((e.getTime() - s.getTime()) / DateUtils.MILLIS_PER_DAY);
		System.out.println(i);
		System.out.println(format.format(DateUtils.addDays(s, i)));
	}
}
