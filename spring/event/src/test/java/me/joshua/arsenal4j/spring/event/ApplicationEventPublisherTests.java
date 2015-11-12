package me.joshua.arsenal4j.spring.event;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

public class ApplicationEventPublisherTests extends AbstractSpringEventTests {

	@Autowired
	private ApplicationEventPublisher publisher;

	/**
	 * <p>
	 * 测试直接注入ApplicationEventPublisher的情况，不通过实现接口的方式使用
	 * <code>ApplicationEventPublisher</code>。
	 * </p>
	 * <p>
	 * 从结果上看，使用正常，但不清楚是否有坑，比如，Spring中注册了多个
	 * <code>ApplicationEventPublisher</code>实现，会出现Autowired异常。
	 * </p>
	 */
	@Test
	public void testDirectlyAutowired() {
		CounterEvent event = new CounterEvent(this);
		publisher.publishEvent(event);
		Assert.assertEquals(1, event.getCount());
	}
}
