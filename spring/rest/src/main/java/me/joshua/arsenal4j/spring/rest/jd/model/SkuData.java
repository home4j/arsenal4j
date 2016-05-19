package me.joshua.arsenal4j.spring.rest.jd.model;

import java.util.List;

import me.joshua.arsenal4j.java.commons.BaseObject;

public class SkuData extends BaseObject {

	private static final long serialVersionUID = -7702197950684955454L;

	private Long pageCount;
	private Long page;
	private Long pageSize;
	private List<Sku> wareInfoList;

	public Long getPageCount() {
		return pageCount;
	}

	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public List<Sku> getWareInfoList() {
		return wareInfoList;
	}

	public void setWareInfoList(List<Sku> wareInfoList) {
		this.wareInfoList = wareInfoList;
	}

}
