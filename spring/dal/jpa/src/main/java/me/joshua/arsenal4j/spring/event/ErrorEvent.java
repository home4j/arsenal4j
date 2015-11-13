package me.joshua.arsenal4j.spring.event;

/**
 * 执行时会抛出异常的事件
 * 
 * @author Joshua
 *
 */
public class ErrorEvent extends AbstractMessageEvent {

	private static final long serialVersionUID = 7714543719477314672L;

	@Override
	public void printMessage() {
		super.printMessage();
		throw new RuntimeException("Error");
	}

}
