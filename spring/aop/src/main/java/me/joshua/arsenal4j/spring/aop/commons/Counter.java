package me.joshua.arsenal4j.spring.aop.commons;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter extends AtomicInteger {

	private static final long serialVersionUID = 6031817135881018679L;

	public void print(String pcc) {
		System.out.println("Count: " + incrementAndGet());
		addPointcutConfig(pcc);
	}

	public List<String> pointcuts = new LinkedList<String>();

	public void addPointcutConfig(String pcc) {
		pointcuts.add(pcc);
	}

	public List<String> getPointcuts() {
		return pointcuts;
	}
}
