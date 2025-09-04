package com.example.barbsalon.services.category;

import com.example.barbsalon.dtos.ApiResponse;
import com.example.barbsalon.dtos.category.CategoryRequest;
import com.example.barbsalon.dtos.category.CategoryResponse;

import java.util.List;

public interface CategoryService {
    public ApiResponse<CategoryResponse> createCategory(CategoryRequest categoryRequest);
    public ApiResponse<List<CategoryResponse>> getCategories();
    public ApiResponse<CategoryResponse> getCategoryById(Long id);
}
