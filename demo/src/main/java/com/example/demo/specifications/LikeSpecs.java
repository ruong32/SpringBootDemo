package com.example.demo.specifications;

import com.example.demo.models.Like;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class LikeSpecs {
    public static Specification<Like> has(String idOf, int id) {
        return new Specification<Like>() {
            public Predicate toPredicate(Root<Like> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return builder.equal(root.get(idOf), id);
            }
        };
    }
}
