package me.joshua.arsenal4j.spring.dal.jpa.domain;

import static me.joshua.arsenal4j.spring.dal.jpa.commons.SpecificationUtils.and;
import static me.joshua.arsenal4j.spring.dal.jpa.commons.SpecificationUtils.appendWildcard;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecs {
	public static Specification<Product> search(final String name,
			final String description) {
		return new Specification<Product>() {

			@Override
			public Predicate toPredicate(Root<Product> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> pList = new LinkedList<Predicate>();
				if (StringUtils.isNotEmpty(name)) {
					pList.add(cb.like(root.get(Product_.name),
							appendWildcard(name)));
				}
				if (StringUtils.isNotEmpty(description)) {
					pList.add(cb.like(root.get(Product_.description),
							appendWildcard(description)));
				}

				return and(cb, pList);
			}
		};
	}
}
