package me.joshua.arsenal4j.spring.rest.jd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import me.joshua.arsenal4j.java.commons.BaseObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Catelogy extends BaseObject {

	private static final long serialVersionUID = 4861305478699272396L;
	private Long id;
	private String name;
	private Long cid;
	private Long level;
	private Long fid;
	private Long flag;
	private Long hot;
	private Long sortno;

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

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public Long getFlag() {
		return flag;
	}

	public void setFlag(Long flag) {
		this.flag = flag;
	}

	public Long getHot() {
		return hot;
	}

	public void setHot(Long hot) {
		this.hot = hot;
	}

	public Long getSortno() {
		return sortno;
	}

	public void setSortno(Long sortno) {
		this.sortno = sortno;
	}

}
