/**
 *    Copyright 2010-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package me.joshua.arsenal4j.spring.dal.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Version;

import me.joshua.arsenal4j.java.commons.BaseObject;

/**
 * 在部分分库分表的情况下，所有的SQL都要传入分表字段，这对于查询比较好解决（每次加入该条件即可）。 但在更新时，Spring
 * Data是不会放入该字段的，所以此处用了一个比较取巧的方法，即把分表字段作为复合主键来配置，这样在更新的时候，都会默认带上该字段了。
 * 
 * @author daonan.zhan
 *
 */
@Entity(name = "trade_order")
@IdClass(OrderPk.class)
public class Order extends BaseObject {

	private static final long serialVersionUID = 350861902233051905L;

	@Id
	@Column(name = "id")
	private Long rowId;

	@Id
	@Column(name = "user_id", nullable = false, unique = true)
	private String userId;

	@Column(name = "descn")
	private String description;

	@Version
	private Long version;

	public Order() {
	}

	public Order(Long rowId, String userId, String description) {
		super();
		this.rowId = rowId;
		this.userId = userId;
		this.description = description;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
