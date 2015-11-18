package me.joshua.arsenal4j.spring.dal.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao extends AbstractJdbcDaoSupport {

	@Autowired
	private ProductMapper productMapper;

	public Product findById(Long id) {
		Object[] args = { id };
		return this.getJdbcTemplate().queryForObject(
				"select * from product where id = ?", args, productMapper);
	}
}
