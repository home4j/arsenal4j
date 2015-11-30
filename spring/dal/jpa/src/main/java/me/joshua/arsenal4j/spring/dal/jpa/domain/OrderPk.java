package me.joshua.arsenal4j.spring.dal.jpa.domain;

import me.joshua.arsenal4j.java.commons.BaseObject;

public class OrderPk extends BaseObject {

	private static final long serialVersionUID = -6750079286730391265L;

	private Long rowId;
	private String userId;

	public OrderPk() {
		super();
	}

	public OrderPk(Long rowId, String userId) {
		super();
		this.rowId = rowId;
		this.userId = userId;
	}

	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/*
	 * 避免为Eclipse的JPA异常检查提示才补的方法，正常情况下是不会这么使用的。
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/*
	 * 避免为Eclipse的JPA异常检查提示才补的方法，正常情况下是不会这么使用的。
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}