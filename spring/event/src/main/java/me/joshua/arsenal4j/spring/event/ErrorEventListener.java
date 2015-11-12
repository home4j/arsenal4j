package me.joshua.arsenal4j.spring.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ErrorEventListener {

	@EventListener
	public void handle(ErrorEvent event) {
		event.printMessage();
	}
}
