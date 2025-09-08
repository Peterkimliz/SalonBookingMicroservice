package com.example.product.controllers;

import com.example.product.dtos.ApiResponse;
import com.example.product.dtos.Pagination;
import com.example.product.dtos.ProductRequest;
import com.example.product.dtos.ProductResponse;
import com.example.product.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Product")
@RestController
@RequestMapping("/api/v1/product/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "create",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<ProductResponse>> createProduct(@ModelAttribute ProductRequest productRequest) {
        return new ResponseEntity<>(productService.createProduct(productRequest), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> getProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> updateProductById(@PathVariable("id") Long id, @RequestBody ProductRequest productRequest) {
        return new ResponseEntity<>(productService.updateProduct(productRequest,id), HttpStatus.OK);
    }

    @GetMapping("all/{id}")
    public ResponseEntity<Pagination<ProductResponse>> getProducts(
            @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
            @PathVariable("id") Long id

    ) {
        return new ResponseEntity<>(productService.getProducts(pageNumber,pageSize,id), HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<?>> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(new ApiResponse<String>(
                "Product Deleted"
        ), HttpStatus.OK);
    }
}
