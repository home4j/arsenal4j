package me.joshua.arsenal4j.spring.rest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import me.joshua.arsenal4j.spring.commons.utils.AbstractSpringJUnit4Tests;
import me.joshua.arsenal4j.spring.rest.jd.JdCrawlService;
import me.joshua.arsenal4j.spring.rest.jd.model.Catelogy;
import me.joshua.arsenal4j.spring.rest.jd.model.Sku;

@ContextConfiguration(classes = { AppConfig.class })
public class JdTemplateTests extends AbstractSpringJUnit4Tests {

	@Autowired
	private JdCrawlService jdCrawlService;

	@Test
	public void testCatelogy() {
		List<Catelogy> list = jdCrawlService.queryCatelogy(1003L);
		System.out.println(list);
	}

	@Test
	public void testSku() {
		List<Sku> skus = jdCrawlService.querySku(6L);
		Assert.assertNotNull(skus);
		Assert.assertTrue(10 < skus.size());
		System.out.println(skus.size());
	}

}
