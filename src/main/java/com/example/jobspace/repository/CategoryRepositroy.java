package com.example.jobspace.repository;

import com.example.jobspace.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositroy extends JpaRepository<Category,Integer> {

}
