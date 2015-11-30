package me.joshua.arsenal4j.spring.dal.jpa.repo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.ContextConfiguration;

import me.joshua.arsenal4j.spring.commons.utils.AbstractSpringJUnit4Tests;
import me.joshua.arsenal4j.spring.dal.jpa.domain.Product;
import me.joshua.arsenal4j.spring.dal.jpa.domain.ProductSpecs;

@ContextConfiguration("classpath*:spring-data.xml")
public class ProductRepositoryTest extends AbstractSpringJUnit4Tests {

	@Autowired
	private ProductRepository productRepository;

	@Test(expected = ObjectOptimisticLockingFailureException.class)
	public void testOptimisticLock() throws Throwable {
		Product product = productRepository.findOne(1L);
		product.setDescription(product.getDescription() + ".");
		System.out.println(productRepository.save(product));
		System.out.println(productRepository.save(product));
	}

	@Test
	public void testSave() {
		Product product = new Product("test", "desc");
		productRepository.save(product);
		Assert.assertNotNull(product.getId());
	}

	@Test
	public void testSpecification() {
		List<Product> list = null;
		list = productRepository.findAll(ProductSpecs.search(null, "fish"));
		Assert.assertEquals(1, list.size());
		list = productRepository.findAll(ProductSpecs.search("SW", null));
		Assert.assertEquals(42, list.size());
		list = productRepository.findAll(ProductSpecs.search("SW2", "fish"));
		Assert.assertEquals(0, list.size());
		list = productRepository.findAll(ProductSpecs.search(null, null));
		Assert.assertTrue(0 < list.size());
	}
}
