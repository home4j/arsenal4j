package me.joshua.arsenal4j.spring.dal.mybatis.commons;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {

	private static final long serialVersionUID = 1212181860954607777L;

	private List<T> contents;
	private Pageable pageable;
	private long total;

	public Page() {
		super();
	}

	public Page(List<T> contents, Pageable pageable, long total) {
		super();
		this.contents = contents;
		this.pageable = pageable;
		this.total = total;
	}

	/**
	 * 当前的页号，以0为初始值
	 * 
	 * @return
	 */
	public int getPageNum() {
		return pageable == null ? 0 : pageable.getPageNum();
	}

	/**
	 * 获取一页的大小
	 * 
	 * @return
	 */
	public int getPageSize() {
		return pageable == null ? 0 : pageable.getPageSize();
	}

	/**
	 * 获取结果列表的内容个数
	 * 
	 * @return
	 */
	public int getContentCount() {
		if (null == contents) {
			return 0;
		}

		return contents.size();
	}

	/**
	 * 获取页码总数
	 * 
	 * @return
	 */
	public int getPageCount() {
		return getPageSize() == 0 ? 1 : (int) Math.ceil((double) total
				/ (double) getPageSize());
	}

	public boolean hasPrevious() {
		return getPageNum() > 0;
	}

	public boolean hasNext() {
		return getPageNum() + 1 < getPageCount();
	}

	public boolean isFirst() {
		return !hasPrevious();
	}

	public boolean isLast() {
		return !hasNext();
	}

	/**
	 * 获取第一页
	 * 
	 * @return
	 */
	public Pageable firstPageable() {
		if (null == pageable) {
			return null;
		}

		return pageable.first();
	}

	/**
	 * 获取
	 * 
	 * @return
	 */
	public Pageable lastPageable() {

		if (null == pageable) {
			return null;
		}

		if (0 == total) {
			return firstPageable();
		}

		if (!hasNext()) {
			return pageable;
		}

		return new PageRequest(getPageNum() + 1, pageable.getPageSize(),
				pageable.getOrders());
	}

	public Pageable nextPageable() {
		return hasNext() ? pageable.next() : null;
	}

	public Pageable previousPageable() {

		if (hasPrevious()) {
			return pageable.previousOrFirst();
		}

		return null;
	}

	public List<T> getContents() {
		return contents;
	}

	public void setContents(List<T> contents) {
		this.contents = contents;
	}

	public Pageable getPageable() {
		return pageable;
	}

	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

}
