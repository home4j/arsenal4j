package me.joshua.arsenal4j.spring.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath*:spring-test.xml")
public class SpringJUnit4Tests extends AbstractSpringJUnit4Tests {

	@Autowired
	private Service service;

	@Test
	public void test() {
		service.invoke();
	}
}
