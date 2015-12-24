package me.joshua.arsenal4j.spring.dal.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import me.joshua.arsenal4j.spring.dal.jpa.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

	public List<Product> findByNameLikeAndDescriptionLike(String name, String description);

	public Product findOneByImagesFront(String front);
}
