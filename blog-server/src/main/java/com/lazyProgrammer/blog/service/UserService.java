package com.lazyProgrammer.blog.service;

import com.lazyProgrammer.blog.dto.ProfileDto;
import com.lazyProgrammer.blog.model.User;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    boolean existsByEmail(String email);
    User getByEmail(String email);
    User save(User user);
    void updateProfile(ProfileDto profile);
    ProfileDto getProfileInfo(String email);
}
