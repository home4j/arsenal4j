package me.joshua.arsenal4j.spring.dal.mybatis.mapper;

import java.util.List;

import me.joshua.arsenal4j.spring.dal.mybatis.commons.Order;
import me.joshua.arsenal4j.spring.dal.mybatis.commons.Pageable;

import org.apache.ibatis.annotations.Param;

public interface BaseMapper<PK, T, P> {

	T findById(@Param("id") PK id);

	Long create(T t);

	Long update(T t);

	List<T> findByParamP(@Param("param") P p, @Param("page") Pageable pageParam);

	List<T> findByParamO(@Param("param") P p, @Param("orders") Order... orders);

	List<T> countByParam(@Param("p") P p);
}
