package me.joshua.arsenal4j.spring.dal.jpa.repo;

import me.joshua.arsenal4j.spring.dal.jpa.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>,
		JpaSpecificationExecutor<Product> {

}
