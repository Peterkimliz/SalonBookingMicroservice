package com.example.barbsalon.mapper.category;

import com.example.barbsalon.dtos.ApiResponse;
import com.example.barbsalon.dtos.category.CategoryRequest;
import com.example.barbsalon.dtos.category.CategoryResponse;
import com.example.barbsalon.models.Category;

public class CategoryMapper {
    public static Category toCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(category.getName().toLowerCase());
        return category;
    }

    public static CategoryResponse toCategoryResponse(Category category) {

        return  new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getUri()
        );
    }
}
