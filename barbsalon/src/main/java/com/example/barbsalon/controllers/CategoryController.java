package com.example.barbsalon.controllers;

import com.example.barbsalon.dtos.ApiResponse;
import com.example.barbsalon.dtos.category.CategoryRequest;
import com.example.barbsalon.dtos.category.CategoryResponse;
import com.example.barbsalon.services.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category/")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = "create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<CategoryResponse>> createCategory(@Validated @ModelAttribute CategoryRequest categoryRequest) {
        return new ResponseEntity<>(categoryService.createCategory(categoryRequest), HttpStatus.CREATED);
    }

    @GetMapping("all")
    public ResponseEntity<ApiResponse<List<CategoryResponse>>> getCategories() {
        return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<CategoryResponse>> getCategoryById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.CREATED);
    }


}
