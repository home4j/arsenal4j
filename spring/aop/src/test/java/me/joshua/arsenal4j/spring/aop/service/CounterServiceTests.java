package me.joshua.arsenal4j.spring.aop.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.joshua.arsenal4j.spring.aop.AbstractSpringAopTests;
import me.joshua.arsenal4j.spring.aop.aspect.CounterAspect;
import me.joshua.arsenal4j.spring.aop.commons.Counter;

public class CounterServiceTests extends AbstractSpringAopTests {

	@Autowired
	private CounterService counterService;
	@Autowired
	private CounterAspect counterAspect;

	@Test
	public void test() {
		Counter counter = new Counter();
		counterService.count(counter);
		Assert.assertEquals(2, counter.get());
	}

	/**
	 * 验证Aspect是否能像正常的Bean一样注入其他的Bean。
	 */
	@Test
	public void testAspectInjection() {
		Assert.assertNotNull(counterAspect.getCounterService());
		Assert.assertEquals(counterService, counterAspect.getCounterService());
	}
}
