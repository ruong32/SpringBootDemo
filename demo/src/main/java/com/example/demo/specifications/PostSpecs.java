package com.example.demo.specifications;

import com.example.demo.models.Post;
import com.example.demo.models.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

public class PostSpecs {
    public static Specification<Post> hasContent(String find) {
        return new Specification<Post>() {
            public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return builder.like(root.get("content"), "%"+find+"%");
            }
        };
    }

    public static Specification<Post> laterThan(Date date) {
        return new Specification<Post>() {
            public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return builder.greaterThanOrEqualTo(root.get("createdAt"), date);
            }
        };
    }
}
