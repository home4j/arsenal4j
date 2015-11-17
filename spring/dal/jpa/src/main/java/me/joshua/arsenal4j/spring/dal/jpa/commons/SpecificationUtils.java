package me.joshua.arsenal4j.spring.dal.jpa.commons;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

public class SpecificationUtils {

	public static final Predicate[] EMPTY_PREDICATE_ARRAY = new Predicate[0];

	public static Predicate and(@NotNull CriteriaBuilder cb,
			List<Predicate> predicates) {
		if (CollectionUtils.isEmpty(predicates)) {
			return null;
		} else if (predicates.size() == 1) {
			return predicates.get(0);
		} else {
			return cb.and(predicates.toArray(EMPTY_PREDICATE_ARRAY));
		}
	}

	public static Predicate and(@NotNull CriteriaBuilder cb,
			Predicate... predicates) {
		if (ArrayUtils.isEmpty(predicates)) {
			return null;
		}

		List<Predicate> list = new LinkedList<Predicate>();
		for (Predicate predicate : predicates) {
			if (null == predicate) {
				continue;
			}

			list.add(predicate);
		}

		return and(cb, list);
	}

	public static Predicate or(@NotNull CriteriaBuilder cb,
			List<Predicate> predicates) {
		if (CollectionUtils.isEmpty(predicates)) {
			return null;
		} else if (predicates.size() == 1) {
			return predicates.get(0);
		} else {
			return cb.or(predicates.toArray(EMPTY_PREDICATE_ARRAY));
		}
	}

	public static Predicate or(@NotNull CriteriaBuilder cb,
			Predicate... predicates) {
		if (ArrayUtils.isEmpty(predicates)) {
			return null;
		}

		List<Predicate> list = new LinkedList<Predicate>();
		for (Predicate predicate : predicates) {
			if (null == predicate) {
				continue;
			}

			list.add(predicate);
		}

		return or(cb, list);
	}

	public static final String WILDCARD_CHAR = "%";

	public static final String appendLeftWildcard(String param) {
		return WILDCARD_CHAR + param;
	}

	public static final String appendRightWildcard(String param) {
		return param + WILDCARD_CHAR;
	}

	public static final String appendWildcard(String param) {
		return WILDCARD_CHAR + param + WILDCARD_CHAR;
	}
}
