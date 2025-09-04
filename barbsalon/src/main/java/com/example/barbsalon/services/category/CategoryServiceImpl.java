package com.example.barbsalon.services.category;

import com.example.barbsalon.dtos.ApiResponse;
import com.example.barbsalon.dtos.category.CategoryRequest;
import com.example.barbsalon.dtos.category.CategoryResponse;
import com.example.barbsalon.exception.ItemFoundException;
import com.example.barbsalon.mapper.category.CategoryMapper;
import com.example.barbsalon.models.Category;
import com.example.barbsalon.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ApiResponse<CategoryResponse> createCategory(CategoryRequest categoryRequest) {
        Optional<Category> categoryByName = categoryRepository.findByName(categoryRequest.name().toLowerCase());
        if (categoryByName.isPresent()) {
            throw new ItemFoundException("category with name already exists");
        }
        Category category = CategoryMapper.toCategory(categoryRequest);
        categoryRepository.save(category);
        return new ApiResponse<>(CategoryMapper.toCategoryResponse(category));
    }

    @Override
    public ApiResponse<List<CategoryResponse>> getCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return new ApiResponse<>(categoryList.stream().map(CategoryMapper::toCategoryResponse).toList());
    }

    @Override
    public ApiResponse<CategoryResponse> getCategoryById(Long id) {
        CategoryResponse categoryResponse = categoryRepository.findById(id)
                        .map(CategoryMapper::toCategoryResponse).orElseThrow(() -> new ItemFoundException("C"));
        return new ApiResponse<>(categoryResponse);
    }

}

