package me.joshua.arsenal4j.spring.aop.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.joshua.arsenal4j.spring.aop.AbstractSpringAopTests;
import me.joshua.arsenal4j.spring.aop.commons.Counter;

public class CounterServiceTests extends AbstractSpringAopTests {

	@Autowired
	private CounterService counterService;

	@Test
	public void test() {
		Counter counter = new Counter();
		counterService.count(counter);
		Assert.assertEquals(2, counter.get());
	}
}
