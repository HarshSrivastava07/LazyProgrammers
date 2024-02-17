package com.lazyProgrammer.blog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.lazyProgrammer.blog.dto.request.PostRequest;
import com.lazyProgrammer.blog.model.Post;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "userEmail", target = "user.email")
    Post postDtoToPost(PostRequest postRequest);
}
