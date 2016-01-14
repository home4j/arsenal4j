package me.joshua.arsenal4j.spring.dal.jpa.repo;

import org.springframework.stereotype.Repository;

import me.joshua.arsenal4j.spring.dal.jpa.domain.ProductExt;

@Repository
public interface ProductExtRepository extends ProductBaseRepository<ProductExt> {

	public ProductExt findByExt(String ext);
}
