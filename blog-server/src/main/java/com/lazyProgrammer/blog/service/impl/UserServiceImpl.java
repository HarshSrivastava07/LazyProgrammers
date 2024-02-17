package com.lazyProgrammer.blog.service.impl;

import com.lazyProgrammer.blog.dto.ProfileDto;
import com.lazyProgrammer.blog.mapper.UserMapper;
import com.lazyProgrammer.blog.model.User;
import com.lazyProgrammer.blog.repository.UserRepository;
import com.lazyProgrammer.blog.service.UserService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updateProfile(ProfileDto profile) {
        try {
            User user = userRepository.findByEmail(profile.getEmail()).get();
            user.setFirstName(profile.getFirstName());
            user.setLastName(profile.getLastName());
            userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ProfileDto getProfileInfo(String email) {
        return UserMapper.INSTANCE.userToProfileDto(userRepository.findByEmail(email).get());
    }
}
