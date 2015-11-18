package me.joshua.arsenal4j.spring.dal.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AbstractJdbcDaoSupport extends JdbcDaoSupport {

	/**
	 * 提供{@code dataSource}配置的注解支持
	 * 
	 * @param dataSource
	 */
	@Autowired
	public void configDataSource(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
}
