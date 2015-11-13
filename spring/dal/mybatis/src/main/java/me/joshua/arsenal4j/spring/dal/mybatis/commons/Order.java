package me.joshua.arsenal4j.spring.dal.mybatis.commons;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * PropertyPath implements the pairing of an {@link Direction} and a property.
 * It is used to provide input for {@link Sort}
 * 
 * @author Oliver Gierke
 * @author Kevin Raymond
 */
public class Order implements Serializable {

	private static final long serialVersionUID = 8986589015229045520L;

	public static final String ASC = "asc";
	public static final String DESC = "desc";
	private static final String DEFAULT_COLUMN = "id";

	private String property = DEFAULT_COLUMN;
	private String direction = ASC;

	/**
	 * Creates a new {@link Order} instance. Direction defaults to
	 * {@link Order#ASC}
	 * 
	 * @param property
	 *            must not be {@literal null} or empty.
	 */
	public Order(String property) {
		this(property, ASC);
	}

	/**
	 * Creates a new {@link Order} instance. if order is {@literal null} then
	 * order defaults to {@link Sort#DEFAULT_DIRECTION}
	 * 
	 * @param property
	 *            must not be {@literal null} or empty.
	 * @param direction
	 *            can be {@literal null}, will default to {@link Order#ASC}
	 */
	public Order(String property, String direction) {
		if (StringUtils.isNoneBlank(property)) {
			this.property = property;
		}
		if (StringUtils.equals(ASC, direction)) {
			this.direction = ASC;
		} else {
			this.direction = DESC;
		}
	}

	/**
	 * Returns whether sorting for this property shall be ascending.
	 * 
	 * @return
	 */
	public boolean isAscending() {
		return StringUtils.equals(this.direction, ASC);
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		if (StringUtils.equals(ASC, direction)) {
			this.direction = ASC;
		} else {
			this.direction = DESC;
		}
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		if (StringUtils.isNoneBlank(property)) {
			this.property = property;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((direction == null) ? 0 : direction.hashCode());
		result = prime * result
				+ ((property == null) ? 0 : property.hashCode());
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
		Order other = (Order) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
