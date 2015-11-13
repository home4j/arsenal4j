package me.joshua.arsenal4j.spring.dal.mybatis.mapper;

import java.util.List;

import me.joshua.arsenal4j.spring.dal.mybatis.commons.Order;
import me.joshua.arsenal4j.spring.dal.mybatis.commons.Pageable;
import me.joshua.arsenal4j.spring.dal.mybatis.domain.Product;
import me.joshua.arsenal4j.spring.dal.mybatis.domain.ProductParam;

import org.apache.ibatis.annotations.Param;

public interface ProductMapper extends BaseMapper<Long, Product, ProductParam> {

	Long partialUpdate(Product product);

	List<Product> findByName(@Param("name") String name);

	List<Product> findByDesc(@Param("desc") String desc);

	List<Product> findByDescP(@Param("desc") String desc,
			@Param("page") Pageable pageParam);

	List<Product> findByDescO(@Param("desc") String desc,
			@Param("orders") Order... orders);
}
