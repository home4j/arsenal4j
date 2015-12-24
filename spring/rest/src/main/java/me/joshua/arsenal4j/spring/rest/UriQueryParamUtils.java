package me.joshua.arsenal4j.spring.rest;

import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.UriComponentsBuilder;

public class UriQueryParamUtils {

	public static final UriComponentsBuilder addMapParam(UriComponentsBuilder builder, String name,
			Map<String, ?> value) {
		if (StringUtils.isBlank(name) || MapUtils.isEmpty(value)) {
			throw new IllegalArgumentException("Empty args");
		}

		for (String key : value.keySet()) {
			builder.queryParam(name + "[" + key + "]", value.get(key));
		}

		return builder;
	}
}
