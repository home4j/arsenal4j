package me.joshua.arsenal4j.spring.event.multithread;

import me.joshua.arsenal4j.java.commons.TimeUtils;
import me.joshua.arsenal4j.spring.event.ErrorEvent;

/**
 * 执行时会抛出异常的事件
 * 
 * @author Joshua
 *
 */
public class SlowErrorEvent extends ErrorEvent {

	private static final long serialVersionUID = 3543472542156607983L;

	@Override
	public void printMessage() {
		TimeUtils.sleep(100);
		super.printMessage();
	}

}
