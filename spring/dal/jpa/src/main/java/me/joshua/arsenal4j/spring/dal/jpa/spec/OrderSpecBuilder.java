package me.joshua.arsenal4j.spring.dal.jpa.spec;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import me.joshua.arsenal4j.spring.dal.jpa.commons.SpecificationUtils;
import me.joshua.arsenal4j.spring.dal.jpa.domain.Order;
import me.joshua.arsenal4j.spring.dal.jpa.domain.Order_;
import me.joshua.arsenal4j.spring.dal.jpa.domain.Product;
import me.joshua.arsenal4j.spring.dal.jpa.domain.Product_;

public class OrderSpecBuilder {

	public static Specification<Order> build(final String productName) {
		return new Specification<Order>() {

			/**
			 * 这么用会产生Cross Join性能较差，不推荐使用
			 */
			@Override
			public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> pList = new LinkedList<Predicate>();

				Root<Product> pRoot = query.from(Product.class);
				pList.add(cb.equal(root.get(Order_.description), pRoot.get(Product_.description)));
				pList.add(cb.equal(pRoot.get(Product_.name), productName));

				return SpecificationUtils.and(cb, pList);
			}
		};
	}

}
