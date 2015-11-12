package me.joshua.arsenal4j.spring.event;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

public class EventListenerTests extends AbstractSpringEventTests {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Test
	public void testChain() {
		ChainEvent event = new ChainEvent();
		publisher.publishEvent(event.message("Chain"));
		assertThat(3, equalTo(event.getCount()));
	}

	@Test(expected = RuntimeException.class)
	public void testException() {
		ErrorEvent event = new ErrorEvent();
		publisher.publishEvent(event.message("Error"));
	}
}
