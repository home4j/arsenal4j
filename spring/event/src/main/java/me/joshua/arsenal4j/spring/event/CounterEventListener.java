package me.joshua.arsenal4j.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CounterEventListener implements ApplicationListener<CounterEvent> {

	@Override
	public void onApplicationEvent(CounterEvent event) {
		event.increase();
		System.out.println(event);
	}
}
