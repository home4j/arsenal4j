package me.joshua.arsenal4j.spring.dal.jpa.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.collections.CollectionUtils;
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

	private static final Predicate[] EMPTY_PREDICATE_ARRAY = new Predicate[0];

	private static Predicate and(CriteriaBuilder cb, List<Predicate> predicates) {
		if (CollectionUtils.isEmpty(predicates)) {
			return null;
		} else if (predicates.size() == 1) {
			return predicates.get(0);
		} else {
			return cb.and(predicates.toArray(EMPTY_PREDICATE_ARRAY));
		}
	}

	public static final String WILDCARD_CHAR = "%";

	@SuppressWarnings("unused")
	private static final String appendLeftWildcard(String param) {
		return WILDCARD_CHAR + param;
	}

	@SuppressWarnings("unused")
	private static final String appendRightWildcard(String param) {
		return param + WILDCARD_CHAR;
	}

	private static final String appendWildcard(String param) {
		return WILDCARD_CHAR + param + WILDCARD_CHAR;
	}
}
