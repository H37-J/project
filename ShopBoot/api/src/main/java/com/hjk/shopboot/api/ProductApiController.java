package com.hjk.shopboot.api;

import com.hjk.shopboot.exception.ValidException;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.hjk.dto.ProductRequestDto;
import com.hjk.model.Product;
import com.hjk.shopboot.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductApiController {

    private final ProductService productService;

    @ApiOperation(value="특정상품 조회 API")
    @RequestMapping(value="get/{id}",method=RequestMethod.GET)
    public ResponseEntity<Product> getId(@PathVariable long id){
        return ResponseEntity.ok(productService.getId(id));
    }

    @ApiOperation(value="모든상품조회 API")
    @RequestMapping(value="getAll",method=RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok(productService.getAll());
    }

    @ApiOperation(value="모든상품조회+PAGE API")
    @RequestMapping(value="getAllPage",method=RequestMethod.GET)
    public ResponseEntity<Page<Product>> getAllProductPage(@PageableDefault(page=1,size=10,sort = "createAt",direction = Sort.Direction.DESC)Pageable pageable){
        return ResponseEntity.ok(productService.getAll(pageable));
    }

    @ApiOperation(value="모든상품조회+PAGE+SEARCH API")
    @RequestMapping(value="getAllPageSearch",params ={"search","keyword"},method=RequestMethod.GET)
    public ResponseEntity<Page<Product>> getAllSearchProductPage(@PageableDefault(page=1,size=10,sort = "createAt",direction = Sort.Direction.DESC)Pageable pageable,
                                                                 @RequestParam String keyword,
                                                                 @RequestParam String search){
        return ResponseEntity.ok(productService.getAll(pageable, keyword, search));
    }

    @ApiOperation(value="상품카테고리 조회1차 API")
    @RequestMapping(value="getProductCategory/{cm}",method=RequestMethod.GET)
    public ResponseEntity<Page<Product>> getCategoryOne(@PathVariable String cm,@PageableDefault(page=1,size=10,sort="createAt",direction = Sort.Direction.DESC)Pageable pageable){
        return ResponseEntity.ok(productService.getProductCategory(pageable,cm));
    }

    @ApiOperation(value="상품카테고리 조회1,2차 API")
    @RequestMapping(value="getProductCategory/{cm}/{cs}",method=RequestMethod.GET)
    public ResponseEntity<Page<Product>> getCategoryTwo(@PathVariable String cm,@PathVariable String cs,@PageableDefault(page=1,size=10,sort="createAt",direction = Sort.Direction.DESC)Pageable pageable){
        return ResponseEntity.ok(productService.getProductCategory(pageable,cm,cs));
    }

    @ApiOperation(value="상품등록API")
    @RequestMapping(value="upload",method=RequestMethod.POST)
    public Product upload(@Valid @RequestBody ProductRequestDto.UploadRequestDto product, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            throw new ValidException(bindingResult);
        }
        return productService.upload(product);
    }

    @ApiOperation(value="상품변경API")
    @RequestMapping(value="update",method=RequestMethod.POST)
    public void update(@Valid @RequestBody ProductRequestDto.ModifyRequestDto product, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            throw new ValidException(bindingResult);
        }
        productService.update(product);
    }

    @ApiOperation(value="상품삭제API")
    @RequestMapping(value="delete",method=RequestMethod.DELETE)
    public void delete(long id){
        productService.delete(id);
    }

 
}
