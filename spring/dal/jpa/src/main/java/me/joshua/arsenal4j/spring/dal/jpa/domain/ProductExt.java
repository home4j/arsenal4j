package me.joshua.arsenal4j.spring.dal.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "product_ext")
public class ProductExt extends ProductBase {

	private static final long serialVersionUID = -9152748057257640187L;

	public ProductExt() {
		super();
	}

	public ProductExt(String name, String description) {
		super(name, description);
	}

	@Column(name = "ext")
	private String ext;

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

}
