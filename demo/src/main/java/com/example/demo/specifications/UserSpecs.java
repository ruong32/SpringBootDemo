package com.example.demo.specifications;

import com.example.demo.models.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class UserSpecs {
    public static Specification<User> userNameIs(String name) {
        return new Specification<User>() {
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return builder.like(root.get("userName"), "%"+name+"%");
            }
        };
    }
}
