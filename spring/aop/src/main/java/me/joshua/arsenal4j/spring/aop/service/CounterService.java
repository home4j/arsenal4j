package me.joshua.arsenal4j.spring.aop.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

/**
 * 无接口的Bean，需使用Cglib代理
 */
@Component
public class CounterService {

	public void count(AtomicInteger counter) {
		System.out.println("Current counter value: " + counter.get());
	}
}
