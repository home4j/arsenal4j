package me.joshua.arsenal4j.spring.dal.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import me.joshua.arsenal4j.spring.dal.jpa.domain.ProductBase;

@NoRepositoryBean
public interface ProductBaseRepository<T extends ProductBase>
		extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

	public List<T> findByNameLikeAndDescriptionLike(String name, String description);

	public T findOneByImagesFront(String front);

	public List<T> findByIdIn(List<Long> ids);

	public List<T> findByIdInAndName(List<Long> ids, String name);

	public T findOneByName(String name);
}
