package me.joshua.arsenal4j.spring.template;

import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerTests extends AbstractSpringTemplateTests {

	@Autowired
	private Configuration config;

	@Test
	public void testMap() throws Throwable {
		Template template = config.getTemplate("welcome.html");
		Map<String, Object> data = new HashMap<>();
		data.put("user", "Joshua Zhan");
		data.put("email", "joshua@gmail.com");
		template.process(data, new OutputStreamWriter(System.out));
	}

	@Test
	public void testLayout() throws Throwable {
		Template template = config.getTemplate("layout/view.html");
		template.process(null, new OutputStreamWriter(System.out));
	}
}
