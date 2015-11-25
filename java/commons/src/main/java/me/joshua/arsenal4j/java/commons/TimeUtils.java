package me.joshua.arsenal4j.java.commons;

public class TimeUtils {

	public static final void sleep(long millis) {
		if (0 >= millis) {
			return;
		}
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
