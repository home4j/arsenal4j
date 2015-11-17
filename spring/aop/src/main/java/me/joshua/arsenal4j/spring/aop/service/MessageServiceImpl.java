package me.joshua.arsenal4j.spring.aop.service;

import me.joshua.arsenal4j.spring.aop.commons.Log;

import org.springframework.stereotype.Component;

@Component
public class MessageServiceImpl implements MessageService {

	/**
	 * 注解必须放在接口的实现类上，否则无效
	 * 
	 * @see MessageService
	 */
	@Log
	@Override
	public void echo(String message) {
		System.out.println(message);
	}
}
