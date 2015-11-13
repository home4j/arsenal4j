package me.joshua.arsenal4j.spring.event;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CounterEventPublisherTests extends AbstractSpringEventTests {

	@Autowired
	private CounterEventPublisher eventPublisher;

	@Test
	public void test() {
		CounterEvent event = eventPublisher.publish();
		assertThat(1, equalTo(event.getCount()));
	}
}
