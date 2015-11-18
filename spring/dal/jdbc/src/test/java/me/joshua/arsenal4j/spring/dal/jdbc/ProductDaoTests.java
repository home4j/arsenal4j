package me.joshua.arsenal4j.spring.dal.jdbc;

import me.joshua.arsenal4j.spring.commons.utils.AbstractSpringJUnit4Tests;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath*:spring-jdbc.xml")
public class ProductDaoTests extends AbstractSpringJUnit4Tests {

	@Autowired
	private ProductDao productDao;

	@Test
	public void testFindById() {
		Product product = productDao.findById(2L);
		System.out.println(product);
	}
}
