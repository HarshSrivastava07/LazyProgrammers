package com.lazyProgrammer.blog.service.impl;

import com.lazyProgrammer.blog.model.Role;
import com.lazyProgrammer.blog.repository.RoleRepository;
import com.lazyProgrammer.blog.service.RoleService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
