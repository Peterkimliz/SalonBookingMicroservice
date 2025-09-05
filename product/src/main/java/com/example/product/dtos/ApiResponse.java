package com.example.product.dtos;

public class ApiResponse<T> {
    private  T data;

    public ApiResponse(T data) {
        this.data = data;

    }

    public ApiResponse() {
    }



    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
