package me.joshua.arsenal4j.java.commons;

import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

public class TestUtils {

	/**
	 * 把Collection中的数据打印
	 * 
	 * @param c
	 */
	public static void print(Object[] objects) {
		if (ArrayUtils.isEmpty(objects)) {
			System.out.println("Empty array");
		}

		System.out.println("Array length: " + objects.length);
		for (Object obj : objects) {
			System.out.println(obj);
		}
	}

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
