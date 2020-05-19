package com.example.demo.specifications;

import com.example.demo.models.Comment;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CommentSpecs {
    public static Specification<Comment> has(String idOf, int id) {
        return new Specification<Comment>() {
            public Predicate toPredicate(Root<Comment> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return builder.equal(root.get(idOf), id);
            }
        };
    }
}
