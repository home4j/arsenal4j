package me.joshua.arsenal4j.spring.rest;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/**
 * 通过配置对比可以看出来，简洁很多
 * 
 * @author daonan.zhan {@link spring-rest.xml}
 */
@Configuration
@ComponentScan("me.joshua.arsenal4j.spring.rest")
public class AppConfig {

	@Bean
	public MappingJackson2HttpMessageConverter httpMessageConverter4Wp() {
		Jackson2ObjectMapperBuilder mapperBuilder = Jackson2ObjectMapperBuilder.json()
		        .propertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(mapperBuilder.build());
		return converter;
	}

	@Bean
	public RestTemplate restTemplate4Wp(HttpMessageConverter<Object> httpMessageConverter4Wp) {
		List<HttpMessageConverter<?>> converters = new LinkedList<>();
		converters.add(httpMessageConverter4Wp);
		return new RestTemplate(converters);
	}

	@Bean
	public MappingJackson2HttpMessageConverter httpMessageConverter4Jd() {
		Jackson2ObjectMapperBuilder mapperBuilder = Jackson2ObjectMapperBuilder.json();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(mapperBuilder.build());
		List<MediaType> types = new LinkedList<>(converter.getSupportedMediaTypes());
		types.add(MediaType.TEXT_PLAIN);
		converter.setSupportedMediaTypes(types);
		return converter;
	}

	@Bean
	public RestTemplate restTemplate4Jd(HttpMessageConverter<Object> httpMessageConverter4Jd) {
		List<HttpMessageConverter<?>> converters = new LinkedList<>();
		converters.add(httpMessageConverter4Jd);
		return new RestTemplate(converters);
	}
}
