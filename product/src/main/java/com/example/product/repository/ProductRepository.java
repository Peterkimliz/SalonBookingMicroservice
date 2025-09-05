package com.example.product.repository;

import com.example.product.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    Page<Product> findBySalonId(Long salonId, PageRequest pageRequest);
}
