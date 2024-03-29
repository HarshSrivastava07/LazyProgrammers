package com.lazyProgrammer.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lazyProgrammer.blog.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
