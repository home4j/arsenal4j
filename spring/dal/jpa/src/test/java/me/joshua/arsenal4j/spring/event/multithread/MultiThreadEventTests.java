package me.joshua.arsenal4j.spring.event.multithread;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import me.joshua.arsenal4j.spring.commons.utils.TimeUtils;
import me.joshua.arsenal4j.spring.event.ErrorEvent;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

public class MultiThreadEventTests extends AbstractSpringEventMultiThreadTests {

	@Autowired
	private ApplicationEventPublisher publisher;

	/**
	 * 在多线程中执行，异常不会被捕获，因此一旦产生，可能会对业务有所影响，需要有补偿机制。
	 */
	@Test
	public void testException() {
		ErrorEvent event = new SlowErrorEvent();
		publisher.publishEvent(event.message("Error"));
		// 因为有等待，所以此时还未执行
		assertThat(0, equalTo(event.getCount()));
		TimeUtils.sleep(150);
		assertThat(1, equalTo(event.getCount()));
	}
}
