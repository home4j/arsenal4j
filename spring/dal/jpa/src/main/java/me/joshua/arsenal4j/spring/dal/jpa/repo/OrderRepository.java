package me.joshua.arsenal4j.spring.dal.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import me.joshua.arsenal4j.spring.dal.jpa.domain.Order;
import me.joshua.arsenal4j.spring.dal.jpa.domain.OrderPk;

@Repository
public interface OrderRepository extends JpaRepository<Order, OrderPk>, JpaSpecificationExecutor<Order> {

	public Order findByUserId(String userId);
}
