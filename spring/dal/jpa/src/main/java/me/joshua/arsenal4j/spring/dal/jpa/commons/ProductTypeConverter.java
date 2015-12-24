package me.joshua.arsenal4j.spring.dal.jpa.commons;

import javax.persistence.AttributeConverter;

import me.joshua.arsenal4j.spring.dal.jpa.domain.ProductType;

public class ProductTypeConverter implements AttributeConverter<ProductType, Integer> {

	@Override
	public Integer convertToDatabaseColumn(ProductType attribute) {
		return attribute.getId();
	}

	@Override
	public ProductType convertToEntityAttribute(Integer dbData) {
		return ProductType.getType(dbData);
	}

}
