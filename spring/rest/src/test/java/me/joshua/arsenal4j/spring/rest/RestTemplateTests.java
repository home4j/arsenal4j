package me.joshua.arsenal4j.spring.rest;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import me.joshua.arsenal4j.spring.rest.wordpress.Post;
import me.joshua.arsenal4j.spring.rest.wordpress.User;

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
	public void testUri() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://www.baidu.com");
		Map<String, String> filterMap = new HashMap<>();
		filterMap.put("type", "post");
		filterMap.put("category", "it");
		UriQueryParamUtils.addMapParam(builder, "filter", filterMap);
		boolean encoded = true;
		// 使用Map的参数，则不能进行编码，否则会抛异常
		// encoded = true;
		UriComponents uriComponents = builder.build(encoded);
		System.out.println(uriComponents);
	}
}
