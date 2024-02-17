package com.lazyProgrammer.blog.service.impl;

import com.lazyProgrammer.blog.dto.request.CategoryRequest;
import com.lazyProgrammer.blog.dto.response.CategoryResponse;
import com.lazyProgrammer.blog.mapper.CategoryMapper;
import com.lazyProgrammer.blog.model.Category;
import com.lazyProgrammer.blog.repository.CategoryRepository;
import com.lazyProgrammer.blog.service.CategoryService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(CategoryRequest category) {
        return categoryRepository.save(CategoryMapper.INSTANCE.categoryDtoToCategory(category));
    }

    @Override
    public List<CategoryResponse> getAll() {
        return CategoryMapper.INSTANCE.categoriesToCategoryDto(categoryRepository.findAll());
    }
}
