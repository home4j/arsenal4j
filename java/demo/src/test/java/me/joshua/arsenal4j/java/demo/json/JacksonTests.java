package me.joshua.arsenal4j.java.demo.json;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author daonan.zhan
 */
public class JacksonTests {

	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void test() throws Exception {
		Account a1, a2;
		String json;
		a1 = new Account(3L, "joshua@test.com");
		json = mapper.writeValueAsString(a1);
		a2 = mapper.readValue(json, Account.class);
		Assert.assertTrue(EqualsBuilder.reflectionEquals(a1, a2, false));

		// 泛型
		Map<Long, Account> map = new HashMap<>();
		map.put(a1.getId(), a1);
		json = mapper.writeValueAsString(map);
		Map<Long, Account> mapResult = mapper.readValue(json, new TypeReference<Map<Long, Account>>() {
		});
		a2 = mapResult.get(a1.getId());
		Assert.assertTrue(EqualsBuilder.reflectionEquals(a1, a2, false));
	}
}
