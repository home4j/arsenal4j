package me.joshua.arsenal4j.spring.dal.jpa.repo;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.joshua.arsenal4j.spring.dal.jpa.AbstractSpringDataTests;
import me.joshua.arsenal4j.spring.dal.jpa.domain.ProductExt;

public class ProductExtRepositoryTests extends AbstractSpringDataTests {

	@Autowired
	private ProductExtRepository productExtRepository;

	/**
	 * 测试Model多级继承的情况
	 */
	@Test
	public void test() {
		ProductExt product = new ProductExt("test", "desc");
		product.setExt("ext");
		productExtRepository.save(product);
		Assert.assertNotNull(product.getId());

		ProductExt p1 = productExtRepository.findByExt(product.getExt());
		Assert.assertEquals(product.getExt(), p1.getExt());
		p1.setDescription(p1.getDescription() + "1");
		p1.setExt(p1.getExt() + "2");
		productExtRepository.save(p1);
		ProductExt p2 = productExtRepository.findOneByName(product.getName());
		Assert.assertEquals(p1.getDescription(), p2.getDescription());
		Assert.assertEquals(p1.getExt(), p2.getExt());
		Assert.assertEquals(new Long(p1.getVersion() + 1L), p2.getVersion());
	}
}
