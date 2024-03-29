package com.lazyProgrammer.blog.controller;

import com.lazyProgrammer.blog.dto.ProfileDto;
import com.lazyProgrammer.blog.dto.response.MessageResponse;
import com.lazyProgrammer.blog.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/profile")
@Validated
public class ProfileController {
    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ProfileDto> getProfile() {
        return ResponseEntity
                .ok(userService.getProfileInfo(SecurityContextHolder.getContext().getAuthentication().getName()));
    }

    @PostMapping
    public ResponseEntity<?> update(@Valid @RequestBody ProfileDto profileDto) {
        profileDto.setEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        userService.updateProfile(profileDto);
        return ResponseEntity.ok(new MessageResponse("Profile update successfully"));
    }
}
