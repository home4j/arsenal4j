package me.joshua.arsenal4j.spring.event;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.context.ApplicationEvent;

public class CounterEvent extends ApplicationEvent {

	private static final long serialVersionUID = -4334994738265315831L;

	private AtomicInteger count = new AtomicInteger(0);

	public CounterEvent(Object source) {
		super(source);
	}

	public int increase() {
		return count.getAndIncrement();
	}

	public int getCount() {
		return count.get();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
