package me.joshua.arsenal4j.spring.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.google.common.io.Resources;

import me.joshua.arsenal4j.java.commons.BaseObject;
import me.joshua.arsenal4j.spring.commons.utils.AbstractSpringJUnit4Tests;
import me.joshua.arsenal4j.spring.rest.jd.JdCrawlService;
import me.joshua.arsenal4j.spring.rest.jd.model.Catelogy;
import me.joshua.arsenal4j.spring.rest.jd.model.Sku;

@ContextConfiguration(classes = { AppConfig.class })
public class JdCrawlServiceTests extends AbstractSpringJUnit4Tests {

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

	@Test
	public void export() throws Throwable {
		List<Catelogy> list = jdCrawlService.queryCatelogy(1003L);
		List<Row> rows = new LinkedList<>();
		for (Catelogy catelogy : list) {
			List<Sku> skus = jdCrawlService.querySku(catelogy.getCid());
			for (Sku sku : skus) {
				rows.add(new Row(catelogy, sku));
			}
		}

		File output = new File(FileUtils.getTempDirectory(), "jd_offer.xlsx");
		try (InputStream is = Resources.getResource("jd_offer.xlsx").openStream();
		        OutputStream os = new FileOutputStream(output)) {
			FileUtils.deleteQuietly(output);
			Context context = new Context();
			context.putVar("rows", rows);
			JxlsHelper.getInstance().processTemplate(is, os, context);
			System.out.println(output.getCanonicalPath());
		}
	}

	public static class Row extends BaseObject {

		private static final long serialVersionUID = -7081801667991302228L;

		public Catelogy catelogy;
		public Sku sku;
		public String url;

		public Row(Catelogy catelogy, Sku sku) {
			super();
			this.catelogy = catelogy;
			this.sku = sku;
			this.url = "http://zgb.m.jd.com/detail.html?id=" + sku.getSkuId();
		}

		public Catelogy getCatelogy() {
			return catelogy;
		}

		public void setCatelogy(Catelogy catelogy) {
			this.catelogy = catelogy;
		}

		public Sku getSku() {
			return sku;
		}

		public void setSku(Sku sku) {
			this.sku = sku;
		}

	}
}
