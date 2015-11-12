package me.joshua.arsenal4j.spring.test;

import org.springframework.stereotype.Component;

@Component
public class Service {

	public void invoke() {
		System.out.println("Hello world!");
	}
}
