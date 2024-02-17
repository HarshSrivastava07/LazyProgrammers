package com.lazyProgrammer.blog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.lazyProgrammer.blog.dto.ProfileDto;
import com.lazyProgrammer.blog.model.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    ProfileDto userToProfileDto(User user);
}
