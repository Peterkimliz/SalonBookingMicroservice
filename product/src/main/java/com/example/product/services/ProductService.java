package com.example.product.services;

import com.example.product.dtos.ApiResponse;
import com.example.product.dtos.Pagination;
import com.example.product.dtos.ProductRequest;
import com.example.product.dtos.ProductResponse;

public interface ProductService {
    ApiResponse<ProductResponse> createProduct(ProductRequest productRequest);
    ApiResponse<ProductResponse>updateProduct(ProductRequest productRequest,Long id);
    ApiResponse<ProductResponse>getProductById(Long id);
    void deleteProduct(Long id);
    Pagination<ProductResponse> getProducts(int pageNumber, int pageSize, Long salonId);
}
