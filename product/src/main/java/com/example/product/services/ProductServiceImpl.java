package com.example.product.services;

import com.example.product.dtos.ApiResponse;
import com.example.product.dtos.Pagination;
import com.example.product.dtos.ProductRequest;
import com.example.product.dtos.ProductResponse;
import com.example.product.exceptions.ItemNotFound;
import com.example.product.mapper.ProductMapper;
import com.example.product.models.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ApiResponse<ProductResponse> createProduct(ProductRequest productRequest) {
       Product product=ProductMapper.toProduct(productRequest);
       productRepository.save(product);
        return new ApiResponse<>(ProductMapper.toProductResponse(product));
    }

    @Override
    public ApiResponse<ProductResponse> updateProduct(ProductRequest productRequest, Long id) {
        return null;
    }

    @Override
    public ApiResponse<ProductResponse> getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ItemNotFound("Product not found"));
        return new ApiResponse<>(ProductMapper.toProductResponse(product));
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ItemNotFound("Product not found"));
        productRepository.delete(product);

    }

    @Override
    public Pagination<ProductResponse> getProducts(int pageNumber, int pageSize, Long salonId) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, "createdAt"));
        Page<Product> products = productRepository.findBySalonId(salonId, pageRequest);

        return new Pagination<>(
                products.getContent().stream().map(ProductMapper::toProductResponse).toList(),
                products.getTotalElements(),
                products.getTotalPages(),
                products.getPageable().getPageNumber(),
                products.getPageable().getPageSize()
        );
    }
}
