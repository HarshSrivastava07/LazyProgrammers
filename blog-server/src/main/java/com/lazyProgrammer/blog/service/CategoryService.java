package com.lazyProgrammer.blog.service;

import com.lazyProgrammer.blog.dto.request.CategoryRequest;
import com.lazyProgrammer.blog.dto.response.CategoryResponse;
import com.lazyProgrammer.blog.model.Category;

import java.util.List;

public interface CategoryService {
    Category save(CategoryRequest category);
    List<CategoryResponse> getAll();
}
