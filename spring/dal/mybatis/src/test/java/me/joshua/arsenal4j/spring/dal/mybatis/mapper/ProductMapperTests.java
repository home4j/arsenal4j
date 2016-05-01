package me.joshua.arsenal4j.spring.dal.mybatis.mapper;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;

import me.joshua.arsenal4j.java.commons.TestUtils;
import me.joshua.arsenal4j.spring.commons.utils.AbstractSpringJUnit4Tests;
import me.joshua.arsenal4j.spring.dal.mybatis.commons.Order;
import me.joshua.arsenal4j.spring.dal.mybatis.commons.PageRequest;
import me.joshua.arsenal4j.spring.dal.mybatis.domain.Product;

@ContextConfiguration("classpath*:spring-mybatis.xml")
public class ProductMapperTests extends AbstractSpringJUnit4Tests {

	@Autowired
	private ProductMapper productMapper;

	@Test
	public void testFindById() {
		Product product = productMapper.findById(1L);
		System.out.println(product);
		Assert.assertNotNull(product);
	}

	@Test
	public void testCreate() {
		Product p = new Product(null, "name", "description");
		System.out.println(productMapper.create(p));
		System.out.println(p);
	}

	@Test(expected = DuplicateKeyException.class)
	public void testUnique() {
		Product p = new Product(null, "Unique", "description");
		productMapper.create(p);
		productMapper.create(p);
	}

	@Test
	public void testUpdate() {
		Product p1 = productMapper.findById(1L);
		p1.setDescription(p1.getDescription() + "-v2");
		p1.setName(p1.getName() + "-v2");
		Assert.assertEquals(productMapper.update(p1), new Long(1));
		p1.setVersion(p1.getVersion() + 1);
		Product p2 = productMapper.findById(1L);
		Assert.assertEquals(p1, p2);
	}

	@Test
	public void testPartialUpdate() {
		Product p1 = productMapper.findById(1L);
		p1.setDescription(p1.getDescription() + "-v2");

		String name = p1.getName();
		p1.setName(null);

		Assert.assertEquals(productMapper.partialUpdate(p1), new Long(1));
		p1.setName(name);
		p1.setVersion(p1.getVersion() + 1);
		Product p2 = productMapper.findById(1L);
		Assert.assertEquals(p1, p2);

		p2.setDescription(null);
		p2.setName(null);
		Long version = p2.getVersion();

		Assert.assertEquals(productMapper.partialUpdate(p2), new Long(1));
		Product p3 = productMapper.findById(1L);
		Assert.assertEquals(new Long(version + 1), p3.getVersion());
	}

	@Test
	public void testLike() {
		List<Product> result = null;
		result = productMapper.findByDesc("Tiger 3");
		Assert.assertEquals(11, result.size());
		result = productMapper.findByDesc("fish");
		Assert.assertEquals(1, result.size());
	}

	@Test
	public void testPage() {
		List<Product> result = null;
		PageRequest page = null;
		page = new PageRequest(1, 7, new Order("version"), new Order("descn",
				Order.DESC));
		result = productMapper.findByDescP("Tiger 3", page);
		TestUtils.print(result);
		page.setOrders(new LinkedList<Order>());
		result = productMapper.findByDescP("Tiger 3", page);
		TestUtils.print(result);
		page.setOrders(null);
		result = productMapper.findByDescP("Tiger 3", page);
		TestUtils.print(result);
	}

	@Test
	public void testOrders() {
		List<Product> result = null;
		result = productMapper.findByDescO("Tiger 3", new Order("version"),
				new Order("descn", Order.DESC));
		TestUtils.print(result);
	}
}
