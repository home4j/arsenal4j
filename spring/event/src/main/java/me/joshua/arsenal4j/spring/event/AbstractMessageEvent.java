package me.joshua.arsenal4j.spring.event;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class AbstractMessageEvent implements Serializable {

	private static final long serialVersionUID = 5903668667078534825L;

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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
