package me.joshua.arsenal4j.spring.rest;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/**
 * 通过配置对比可以看出来，简洁很多
 * 
 * @author daonan.zhan
 * {@link spring-rest.xml}
 */
@Configuration
public class AppConfig {

	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		new Jackson2ObjectMapperBuilder();
		Jackson2ObjectMapperBuilder mapperBuilder = Jackson2ObjectMapperBuilder.json()
				.propertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		return new MappingJackson2HttpMessageConverter(mapperBuilder.build());
	}

	@Bean
	public RestTemplate restTemplate(MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter) {
		List<HttpMessageConverter<?>> converters = new LinkedList<>();
		converters.add(mappingJackson2HttpMessageConverter);
		return new RestTemplate(converters);
	}
}
