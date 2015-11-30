package me.joshua.arsenal4j.spring.event;

import java.util.concurrent.atomic.AtomicInteger;

import me.joshua.arsenal4j.java.commons.BaseObject;

public abstract class AbstractMessageEvent extends BaseObject {

	private static final long serialVersionUID = 5311708231559122819L;

	protected String message;
	protected final AtomicInteger count = new AtomicInteger();

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AbstractMessageEvent message(String message) {
		this.message = message;
		return this;
	}

	public void printMessage() {
		count.incrementAndGet();
		System.out.println(message);
	}

	public int getCount() {
		return count.get();
	}

}
