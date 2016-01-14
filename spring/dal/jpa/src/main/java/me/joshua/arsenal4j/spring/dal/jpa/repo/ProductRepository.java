package me.joshua.arsenal4j.spring.dal.jpa.repo;

import org.springframework.stereotype.Repository;

import me.joshua.arsenal4j.spring.dal.jpa.domain.Product;

@Repository
public interface ProductRepository extends ProductBaseRepository<Product> {

}
