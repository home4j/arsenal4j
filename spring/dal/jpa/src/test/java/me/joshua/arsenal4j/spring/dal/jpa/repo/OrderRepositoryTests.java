package me.joshua.arsenal4j.spring.dal.jpa.repo;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;

import me.joshua.arsenal4j.spring.dal.jpa.AbstractSpringDataTests;
import me.joshua.arsenal4j.spring.dal.jpa.domain.Order;
import me.joshua.arsenal4j.spring.dal.jpa.spec.OrderSpecBuilder;

public class OrderRepositoryTests extends AbstractSpringDataTests {

	@Autowired
	private OrderRepository orderRepository;

	@Test
	public void testVersion() {
		Order order = new Order(2L, "joshua", "Hello joshua");
		System.out.println("Create a new order, before save");
		System.out.println(order);
		orderRepository.save(order); // 新建时，version会被自动设置

		System.out.println("After save, version is set");
		System.out.println(order);
		Assert.assertEquals(new Long(0), order.getVersion());
		order.setDescription("Hello world!");
		orderRepository.save(order); // 更新的时候，version不会自动更新的
		Assert.assertEquals(new Long(0), order.getVersion());

		order = orderRepository.findByUserId(order.getUserId());
		Assert.assertEquals(new Long(1), order.getVersion());
	}

	@Test
	public void testJoin() {
		Order o = orderRepository.findOne(OrderSpecBuilder.build("join_name"));
		System.out.println(o);
	}

	@Test(expected = ObjectOptimisticLockingFailureException.class)
	public void testOptimisticLock() throws Throwable {
		Order order = orderRepository.findByUserId("joshuazhan");
		Assert.assertNotNull(order);

		order.setDescription("Hello");
		orderRepository.save(order);
		orderRepository.save(order); // 乐观锁异常
	}
}
