package me.joshua.arsenal4j.spring.dal.jpa.repo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.ContextConfiguration;

import me.joshua.arsenal4j.spring.commons.utils.AbstractSpringJUnit4Tests;
import me.joshua.arsenal4j.spring.dal.jpa.domain.Order;
import me.joshua.arsenal4j.spring.dal.jpa.domain.Product;
import me.joshua.arsenal4j.spring.dal.jpa.domain.ProductImages_;
import me.joshua.arsenal4j.spring.dal.jpa.domain.ProductSpecs;
import me.joshua.arsenal4j.spring.dal.jpa.domain.ProductType;
import me.joshua.arsenal4j.spring.dal.jpa.domain.Product_;

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

	@Test
	public void testConverter() {
		Product p = productRepository.findOne(3L);
		Assert.assertEquals(ProductType.CLOTHES, p.getType());
	}

	@Test
	public void testLike() {
		final String name = "%SW%";
		List<Product> products = null;
		products = productRepository.findByNameLikeAndDescriptionLike(name, "%iger%");
		Assert.assertEquals(2, products.size());
	}

	@Test
	public void testEmbedded() {
		final String front = "front1";
		Product p = null;
		p = productRepository.findOneByImagesFront(front);
		Assert.assertNotNull(p);
		productRepository.findOne(new Specification<Product>() {

			@Override
			public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 多级嵌套的属性，需要链式的获取属性配置
				return cb.equal(root.get(Product_.images).get(ProductImages_.front), front);
			}
		});
		Assert.assertEquals(front, p.getImages().getFront());
	}

	@Test
	public void testIn() {
		List<Long> ids = new LinkedList<>();
		ids.add(1L);
		ids.add(2L);
		List<Product> list = null;
		list = productRepository.findByIdIn(ids);
		Assert.assertEquals(2, list.size());

		list = productRepository.findByIdInAndName(ids, "FI-SW-02");
		Assert.assertEquals(1, list.size());

	}

	@Test
	public void testPerformance() {
		int total = 1000000;
		for (int i = 0; i < total; i++) {
			Product product = new Product("test" + i, "desc" + i);
			productRepository.save(product);
		}
		productRepository.flush();

		StopWatch watch = new StopWatch();
		watch.start();
		for (int i = 0; i < total; i++) {
			Product product = productRepository.findOneByName("test" + i);
			System.out.println(product);
		}
		watch.stop();
		System.out.println("Start: " + new Date(watch.getStartTime()));
		System.out.println("Total: " + DurationFormatUtils.formatDurationHMS(watch.getTime()));
		System.out.println("Per request: " + watch.getTime() / total);
	}
}
