package com.example.product.mapper;


import com.example.product.dtos.ProductRequest;
import com.example.product.dtos.ProductResponse;
import com.example.product.models.Product;

import java.time.LocalDateTime;

public class ProductMapper {
    public static ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity(),
                product.getCreatedAt(),
                product.getImageUrl(),
                product.getSalonId()
        );
    }

    public static Product toProduct(ProductRequest productRequest) {
        Product product=new Product();
        product.setName(productRequest.name());
        product.setPrice(productRequest.price());
        product.setDescription(productRequest.description());
        product.setCreatedAt(LocalDateTime.now());
        product.setQuantity(productRequest.quantity());
        product.setSalonId(productRequest.salonId());
        return  product;
    }
}
