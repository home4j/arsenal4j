package me.joshua.arsenal4j.spring.rest;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import me.joshua.arsenal4j.spring.rest.wordpress.model.Post;
import me.joshua.arsenal4j.spring.rest.wordpress.model.User;

public class RestTemplateTests extends AbstractSpringRestTests {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void testUsers() {
		User user = restTemplate.getForObject("http://home4j.duapp.com/wp-json/wp/v2/users/1", User.class);
		System.out.println(user);
	}

	@Test
	public void testPosts() {
		Post[] posts = restTemplate
		        .getForObject("http://home4j.duapp.com/wp-json/wp/v2/posts?filter[category_name]=java", Post[].class);
		for (Post post : posts) {
			System.out.println(post.getTitle());
		}
	}

	@Test
	public void testFilter() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://home4j.duapp.com/wp-json/wp/v2/posts");
		Map<String, String> filterMap = new HashMap<>();
		filterMap.put("category_name", "java");
		UriQueryParamUtils.addMapParam(builder, "filter", filterMap);
		UriComponents uriComponents = builder.build();
		Post[] posts = restTemplate.getForObject(uriComponents.toUri(), Post[].class);
		Assert.assertTrue(0 < posts.length);
	}

}
