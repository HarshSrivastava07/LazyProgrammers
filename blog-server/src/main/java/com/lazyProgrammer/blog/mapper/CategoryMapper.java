package com.lazyProgrammer.blog.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.lazyProgrammer.blog.dto.request.CategoryRequest;
import com.lazyProgrammer.blog.dto.response.CategoryResponse;
import com.lazyProgrammer.blog.model.Category;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category categoryDtoToCategory(CategoryRequest category);
    List<CategoryResponse> categoriesToCategoryDto(List<Category> categories);
}
