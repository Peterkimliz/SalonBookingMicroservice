package com.example.barbsalon.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ElementCollection
    private List<String> images;
    @Column(nullable = false, length = 2000)
    private String about;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private Long owner;
    private Double totalRating;
    private Integer ratingCount;

    @Column(nullable = false)
    private Double latitude;
    @Column(nullable = false)
    private Double longitude;
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Salon() {
    }

    public Salon(Long id, String name, String address, Category category, List<String> images,
                 String about, String email, String city, String phone, Long owner, Double totalRating,
                 Integer ratingCount, Double latitude, Double longitude, LocalDateTime createdAt,
                 LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.category = category;
        this.images = images;
        this.about = about;
        this.email = email;
        this.city = city;
        this.phone = phone;
        this.owner = owner;
        this.totalRating = totalRating;
        this.ratingCount = ratingCount;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public Double getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(Double totalRating) {
        this.totalRating = totalRating;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
