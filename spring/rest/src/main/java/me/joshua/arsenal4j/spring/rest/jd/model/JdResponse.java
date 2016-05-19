package me.joshua.arsenal4j.spring.rest.jd.model;

import me.joshua.arsenal4j.java.commons.BaseObject;

public class JdResponse<T> extends BaseObject {

	private static final long serialVersionUID = -1800807206947644184L;
	private T data;
	private String code;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
