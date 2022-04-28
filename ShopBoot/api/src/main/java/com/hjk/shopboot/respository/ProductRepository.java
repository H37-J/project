package com.hjk.shopboot.respository;


import com.hjk.model.Product;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>,JpaSpecificationExecutor{
    Product findById(long id);
    @NotNull
    List<Product> findAll(Specification spec);
    @NotNull
    Page<Product> findAll(Specification spec, @NotNull Pageable pageable);

}
