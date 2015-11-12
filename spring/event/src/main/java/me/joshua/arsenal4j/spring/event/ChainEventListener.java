package me.joshua.arsenal4j.spring.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ChainEventListener {

	/**
	 * 返回的结果将会被当成事件继续发送出去，
	 * 
	 * @param event
	 * @return
	 * @see EventListener
	 */
	@EventListener(condition = "#event.count < 3")
	public ChainEvent handle(ChainEvent event) {
		event.printMessage();
		return event;
	}
}
