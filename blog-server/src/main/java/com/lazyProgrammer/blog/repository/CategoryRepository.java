package com.lazyProgrammer.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lazyProgrammer.blog.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
