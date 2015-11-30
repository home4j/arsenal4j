package me.joshua.arsenal4j.spring.dal.jdbc;

import me.joshua.arsenal4j.java.commons.BaseObject;

public class Product extends BaseObject {

	private static final long serialVersionUID = -7492639752670189553L;

	private Long id;

	private String name;

	private String description;

	private Long version;

	public Product() {
	}

	public Product(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		this.version = 0L;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

}
