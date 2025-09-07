package com.example.barbsalon.dtos;

import java.util.List;

public record Pagination<T>(
    List<T>data,
    Long totalElements,
    Integer totalPages,
    int pageNumber ,
    int pageSize
){}
