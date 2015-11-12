package me.joshua.arsenal4j.spring.event.hierarchy;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SubEventHandler {

	@EventListener
	public void handle(SubEvent event) {
		event.printMessage();
	}
}
