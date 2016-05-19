package me.joshua.arsenal4j.spring.rest.jd.model;

import java.util.List;

import me.joshua.arsenal4j.java.commons.BaseObject;

public class CatelogyData extends BaseObject {

	private static final long serialVersionUID = -3070008018482890944L;

	private List<Catelogy> catelogys;

	public List<Catelogy> getCatelogys() {
		return catelogys;
	}

	public void setCatelogys(List<Catelogy> catelogys) {
		this.catelogys = catelogys;
	}

}
