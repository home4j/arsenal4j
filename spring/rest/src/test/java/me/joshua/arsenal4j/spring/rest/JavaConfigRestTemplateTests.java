package me.joshua.arsenal4j.spring.rest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import me.joshua.arsenal4j.spring.commons.utils.AbstractSpringJUnit4Tests;
import me.joshua.arsenal4j.spring.rest.wordpress.model.User;

@ContextConfiguration(classes = { AppConfig.class })
public class JavaConfigRestTemplateTests extends AbstractSpringJUnit4Tests {

	@Autowired
	@Qualifier("restTemplate4Wp")
	private RestTemplate restTemplate;

	@Test
	public void test() {
		User user = restTemplate.getForObject("http://home4j.duapp.com/wp-json/wp/v2/users/1", User.class);
		System.out.println(user);
	}
}
