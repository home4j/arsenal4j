package me.joshua.arsenal4j.spring.rest.jd.model;

import me.joshua.arsenal4j.java.commons.BaseObject;

public class CatelogyParam extends BaseObject {

	private static final long serialVersionUID = 8572035445977526032L;

	private Long page;
	private Long pageSize;
	private String cid;

	public CatelogyParam() {
		super();
	}

	public CatelogyParam(Long page, Long pageSize, Long cid) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		if (null != cid) {
			this.cid = cid.toString();
		}
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

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public void setCid(Long cid) {
		if (null != cid) {
			this.cid = cid.toString();
		}
	}

}
