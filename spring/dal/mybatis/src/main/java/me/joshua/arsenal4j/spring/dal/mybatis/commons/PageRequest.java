package me.joshua.arsenal4j.spring.dal.mybatis.commons;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PageRequest implements Pageable, Serializable {

	private static final long serialVersionUID = 1232825578694716871L;

	private int pageNum = 0;
	private int pageSize = 20;
	private List<Order> orders;

	/**
	 * Creates a new {@link PageRequest}. Pages are zero indexed, thus providing
	 * 0 for {@code page} will return the first page.
	 * 
	 * @param page
	 *            must not be less than zero.
	 * @param pageSize
	 *            must not be less than one.
	 */
	public PageRequest(int page, int pageSize, List<Order> orders) {

		if (page < 0) {
			throw new IllegalArgumentException(
					"Page index must not be less than zero!");
		}

		if (pageSize < 1) {
			throw new IllegalArgumentException(
					"Page size must not be less than one!");
		}

		this.pageNum = page;
		this.pageSize = pageSize;
		this.orders = orders;
	}

	/**
	 * Creates a new {@link PageRequest}. Pages are zero indexed, thus providing
	 * 0 for {@code page} will return the first page.
	 * 
	 * @param page
	 *            must not be less than zero.
	 * @param pageSize
	 *            must not be less than one.
	 */
	public PageRequest(int page, int pageSize, Order... orders) {

		if (page < 0) {
			throw new IllegalArgumentException(
					"Page index must not be less than zero!");
		}

		if (pageSize < 1) {
			throw new IllegalArgumentException(
					"Page size must not be less than one!");
		}

		this.pageNum = page;
		this.pageSize = pageSize;

		if (ArrayUtils.isNotEmpty(orders)) {
			List<Order> orderList = new LinkedList<Order>();
			CollectionUtils.addAll(orderList, orders);
			this.orders = orderList;
		}
	}

	@Override
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public int getOffset() {
		return pageNum * pageSize;
	}

	@Override
	public boolean hasPrevious() {
		return pageNum > 0;
	}

	@Override
	public Pageable previousOrFirst() {
		return hasPrevious() ? previous() : first();
	}

	@Override
	public Pageable next() {
		return new PageRequest(getPageNum() + 1, getPageSize(), getOrders());
	}

	@Override
	public Pageable previous() {
		if (0 < getPageNum()) {
			return new PageRequest(getPageNum() - 1, getPageSize(), getOrders());
		} else {
			return null;
		}
	}

	@Override
	public Pageable first() {
		return new PageRequest(0, getPageSize(), getOrders());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result + pageNum;
		result = prime * result + pageSize;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageRequest other = (PageRequest) obj;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		if (pageNum != other.pageNum)
			return false;
		if (pageSize != other.pageSize)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
