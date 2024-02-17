package com.lazyProgrammer.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lazyProgrammer.blog.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
     Long countPostByCategory_Name(String category_name);
}
