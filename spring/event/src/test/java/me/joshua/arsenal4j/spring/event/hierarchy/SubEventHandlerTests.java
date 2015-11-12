package me.joshua.arsenal4j.spring.event.hierarchy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import me.joshua.arsenal4j.spring.event.AbstractSpringEventTests;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

public class SubEventHandlerTests extends AbstractSpringEventTests {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Test
	public void subEventTest() {
		SubEvent event = new SubEvent();
		publisher.publishEvent(event.message("Sub"));
		assertThat(2, equalTo(event.getCount()));
	}
}
