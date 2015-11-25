package me.joshua.arsenal4j.java.commons;

import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;

public class TestUtils {

	/**
	 * 把Collection中的数据打印
	 * 
	 * @param c
	 */
	public static <T> void print(Collection<T> c) {
		if (CollectionUtils.isEmpty(c)) {
			System.out.println("Empty collection");
			return;
		}

		System.out.println("Item count: " + c.size());
		for (T item : c) {
			System.out.println(item);
		}
	}
}
