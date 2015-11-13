package me.joshua.arsenal4j.spring.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * 根据Spring文档<a
 * href="http://docs.spring.io/spring/docs/current/spring-framework-reference/
 * htmlsingle/#context-functionality-events">Spring事件</a>中的示例，事件发布服务需实现
 * {@code ApplicationEventPublisher}接口。但貌似直接使用{@code ApplicationEventPublisher}
 * 也没有什么大问题。
 * 
 * @author Joshua
 * @see ApplicationEventPublisherTests
 */
@Component
public class CounterEventPublisher implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher publisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	public CounterEvent publish() {
		CounterEvent event = new CounterEvent(this);
		publisher.publishEvent(event);
		return event;
	}
}
