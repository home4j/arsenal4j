package me.joshua.arsenal4j.spring.dal.jpa.repo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.ContextConfiguration;

import me.joshua.arsenal4j.spring.commons.utils.AbstractSpringJUnit4Tests;
import me.joshua.arsenal4j.spring.dal.jpa.domain.Order;

@ContextConfiguration("classpath*:spring-data.xml")
public class OrderRepositoryTest extends AbstractSpringJUnit4Tests {

	@Autowired
	private OrderRepository orderRepository;

	@Test
	public void testSave() {
		Order order = new Order(2L, "joshua", "Hello joshua");

		System.out.println("Create a new order, before save");
		System.out.println(order);
		orderRepository.save(order); // 只有新建时，version才会被自动设置

		System.out.println("After save, version is set");
		System.out.println(order);

		System.out.println("Update that order");
		order.setDescription("Hello world!");
		orderRepository.save(order); // 更新的时候，version是不会自动更新的
		System.out.println("After save that param order, version is not updated");
		System.out.println(order);

		order = orderRepository.findByUserId(order.getUserId());

		System.out.println("Select the order from repository, version is changed");
		System.out.println(order);
	}

	@Test(expected = ObjectOptimisticLockingFailureException.class)
	public void testOptimisticLock() throws Throwable {
		Order order = orderRepository.findByUserId("joshuazhan");
		System.out.println("Select the order, before save");
		System.out.println(order);

		order.setDescription("Hello");
		orderRepository.save(order);
		System.out.println("After save, version is not updated");
		System.out.println(order);

		System.out.println("Update the order, failed due to optimistic lock");
		orderRepository.save(order);
	}
}
