package me.joshua.arsenal4j.spring.dal.jpa.domain;

import java.util.HashMap;
import java.util.Map;

public enum ProductType {
	TOY(1), CLOTHES(2);

	private static Map<Integer, ProductType> TYPE_MAP = new HashMap<>();

	static {
		for (ProductType type : ProductType.values()) {
			TYPE_MAP.put(type.getId(), type);
		}
	}

	private final Integer id;

	private ProductType(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public static ProductType getType(Integer id) {
		ProductType type = null;
		if (null != id) {
			type = TYPE_MAP.get(id);
		}

		if (null == type) {
			return ProductType.TOY;
		}

		return type;
	}

}
