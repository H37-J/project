package com.hjk.shopboot.utils.specification;

import com.hjk.model.Product;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductSpecs {

    // 검색
    public static Specification<Product> hasTitle(String keyword, String search) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(@NotNull Root<Product> root, @NotNull CriteriaQuery<?> criteriaQuery,
                    @NotNull CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(search), "%" + keyword + "%");
            }
        };
    }

    // 상품 필터링(가격,사이즈)
    public static Specification<Product> hasFilterProduct(String cm, String cs, String field, int priceMin,
            int priceMax, String size) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(@NotNull Root<Product> root, @NotNull CriteriaQuery<?> criteriaQuery,
                    @NotNull CriteriaBuilder criteriaBuilder) {
                if (size=="") {
                    if (cs == "") {
                        return criteriaBuilder.and(criteriaBuilder.like(root.get("category_main"), cm),
                                criteriaBuilder.between(root.get(field), priceMin, priceMax));
                    } else {
                        return criteriaBuilder.and(
                                criteriaBuilder.and(criteriaBuilder.like(root.get("category_main"), cm),
                                        criteriaBuilder.like(root.get("category_sub"), cs)),
                                criteriaBuilder.between(root.get(field), priceMin, priceMax));
                    }
                } else {
                    if (cs == "") {
                        return criteriaBuilder.and(criteriaBuilder.like(root.get("size"),size),criteriaBuilder.and(criteriaBuilder.like(root.get("category_main"), cm),
                        criteriaBuilder.between(root.get(field), priceMin, priceMax)));
                    } else {
                        return criteriaBuilder.and(criteriaBuilder.like(root.get("size"),size),criteriaBuilder.and(
                            criteriaBuilder.and(criteriaBuilder.like(root.get("category_main"), cm),
                                    criteriaBuilder.like(root.get("category_sub"), cs)),
                            criteriaBuilder.between(root.get(field), priceMin, priceMax)));
                    }
                }
            }
        };
    }

    // 카테고리 1차
    public static Specification<Product> hasProductCategory(String cm) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(@NotNull Root<Product> root, @NotNull CriteriaQuery<?> criteriaQuery,
                    @NotNull CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("category_main"), cm);
            }
        };
    }

    // 카테고리 1,2차
    public static Specification<Product> hasProductCategory(String cm, String cs) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(@NotNull Root<Product> root, @NotNull CriteriaQuery<?> criteriaQuery,
                    @NotNull CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.and(criteriaBuilder.like(root.get("category_main"), cm),
                        criteriaBuilder.like(root.get("category_sub"), cs));
            }
        };
    }

}
