package com.hjk.shopboot.service;

import com.hjk.shopboot.respository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hjk.dto.ProductRequestDto;
import com.hjk.model.Product;
import com.hjk.shopboot.utils.files.FileUtils;
import com.hjk.shopboot.utils.specification.ProductSpecs;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final ReviewRepository reviewRepository;
    private final LikesRepository likesRepository;

    // 특정상품 조회
    public Product getId(long id) {
        return productRepository.findById(id);
    }

    // 모든상품 조회
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    // 모든상품 조회+PAGE
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    // 모든상품 조회+PAGE+SEARCH
    public Page<Product> getAll(Pageable pageable, String keyword, String search) {
        Specification<Product> spec = Specification.where(ProductSpecs.hasTitle(keyword, search));
        return productRepository.findAll(spec, pageable);
    }

    // 상품페이지 카테고리별 분류 조회(1차)
    public List<Product> getProductCategory(String cm) {
        Specification<Product> spec = Specification.where(ProductSpecs.hasProductCategory(cm));
        return productRepository.findAll(spec);
    }

    // 상품페이지 카테고리별 분류 조회(1차)+PAGE
    public Page<Product> getProductCategory(Pageable pageable, String cm) {
        Specification<Product> spec = Specification.where(ProductSpecs.hasProductCategory(cm));
        return productRepository.findAll(spec, pageable);
    }

    // 상품페이지 카테고리별 분류 조회(1,2)
    public List<Product> getProductCategory(String cm, String cs) {
        Specification<Product> spec = Specification.where(ProductSpecs.hasProductCategory(cm, cs));
        return productRepository.findAll(spec);
    }

    // 상품페이지 카테고리별 분류 조회(1,2)+PAGE
    public Page<Product> getProductCategory(Pageable pageable, String cm, String cs) {
        Specification<Product> spec = Specification.where(ProductSpecs.hasProductCategory(cm, cs));
        return productRepository.findAll(spec, pageable);
    }

    //가격 필터링
    public Page<Product> getAllFilterPrice(Pageable pageable, String cm, String cs, String field, int priceMin,
            int priceMax,String size) {
        Specification<Product> spec = Specification
                .where(ProductSpecs.hasFilterProduct(cm, cs, field, priceMin, priceMax,size));
        return productRepository.findAll(spec, pageable);
    }

    // 상품등록
    public Product upload(ProductRequestDto.UploadRequestDto product) throws Exception{
        productRepository.save(product.toEntity());
        List<Product> list=getAll();
        return list.get(list.size()-1);
    }

    //상품수정
    public void update(ProductRequestDto.ModifyRequestDto product) throws Exception{
        productRepository.save(product.toEntity());
    }

    // 상품삭제
    public void delete(long id) {
        orderRepository.deleteByProduct(id);
        cartRepository.deleteByProduct(id);
        likesRepository.deleteByProduct(id);
        reviewRepository.deleteByProduct(id);
        productRepository.deleteById(id);
    }

}
