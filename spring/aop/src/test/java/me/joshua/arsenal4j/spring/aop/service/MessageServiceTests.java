package me.joshua.arsenal4j.spring.aop.service;

import me.joshua.arsenal4j.spring.aop.AbstractSpringAopTests;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageServiceTests extends AbstractSpringAopTests {

	@Autowired
	private MessageService messageService;

	@Test
	public void testEcho() {
		messageService.echo("Hello world");
	}

}
