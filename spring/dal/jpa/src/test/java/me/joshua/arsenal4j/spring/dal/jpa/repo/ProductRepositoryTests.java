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
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import me.joshua.arsenal4j.spring.dal.jpa.AbstractSpringDataTests;
import me.joshua.arsenal4j.spring.dal.jpa.domain.Product;
import me.joshua.arsenal4j.spring.dal.jpa.domain.ProductImages_;
import me.joshua.arsenal4j.spring.dal.jpa.domain.ProductType;
import me.joshua.arsenal4j.spring.dal.jpa.domain.Product_;
import me.joshua.arsenal4j.spring.dal.jpa.spec.ProductSpecBuilder;

public class ProductRepositoryTests extends AbstractSpringDataTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void testSave() {
		Product product = new Product("test", "desc");
		productRepository.save(product);
		Assert.assertNotNull(product.getId());

		Product p1;
		p1 = productRepository.findOneByName(product.getName());
		System.out.println("P1 just save: ");
		System.out.println(p1);
		p1.setDescription(p1.getDescription() + "1");
		productRepository.save(p1);
		p1 = productRepository.findOneByName(product.getName());
		System.out.println("P1 description updated: ");
		System.out.println(p1);

		Product p2 = new Product(p1.getName(), p1.getDescription() + "2");
		p2.setId(p1.getId());
		p2.setImages(p1.getImages());
		p2.setType(p1.getType());
		p2.setVersion(p1.getVersion());
		System.out.println("P2 copy from P1:");
		System.out.println(p2);
		productRepository.save(p2);
		System.out.println("P2 after updated:");
		System.out.println(p2);
		p2 = productRepository.findOneByName(product.getName());
		System.out.println("P2 retrieved from DB:");
		System.out.println(p2);
	}

	@Test
	public void testSpecification() {
		List<Product> list = null;
		list = productRepository.findAll(ProductSpecBuilder.build(null, "fish"));
		Assert.assertEquals(1, list.size());
		list = productRepository.findAll(ProductSpecBuilder.build("SW", null));
		Assert.assertEquals(3, list.size());
		list = productRepository.findAll(ProductSpecBuilder.build("SW2", "fish"));
		Assert.assertEquals(0, list.size());
		list = productRepository.findAll(ProductSpecBuilder.build(null, null));
		Assert.assertTrue(0 < list.size());
		list = productRepository.findAll((Specification<Product>) null);
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
	@Ignore
	public void testPerformance() {
		int total = 1000;
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
