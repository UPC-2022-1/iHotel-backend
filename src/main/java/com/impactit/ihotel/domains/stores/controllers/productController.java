package com.impactit.ihotel.domains.stores.controllers;

import com.impactit.ihotel.domains.stores.domain.service.ProductService;
import com.impactit.ihotel.domains.stores.mapping.ProductMapper;
import com.impactit.ihotel.domains.stores.resource.ProductRequestResource;
import com.impactit.ihotel.domains.stores.resource.ProductResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/products")
public class productController {

    @Autowired
    private final ProductService productService;

    private final ProductMapper mapper;


    public productController(ProductService productService, ProductMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ProductResource> getAllProduct(Pageable pageable){
        return mapper.modelListPage(productService.getAll(), pageable);
    }

    @PostMapping
    public ResponseEntity<ProductResource> createProduct (@RequestBody ProductRequestResource resource) {
        return new ResponseEntity<>(mapper.toResource(productService.create(
                mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{productId}")
    public ProductResource updateProduct( @PathVariable Long productId,@RequestBody ProductRequestResource resource){
        return mapper.toResource(productService.update(productId, mapper.toModel(resource)));
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        return productService.delete(productId);
    }

}
