package com.lazyProgrammer.blog.service;

import com.lazyProgrammer.blog.dto.request.PostRequest;
import com.lazyProgrammer.blog.dto.response.PostDetailResponse;
import com.lazyProgrammer.blog.dto.response.PostListResponse;
import com.lazyProgrammer.blog.dto.response.PostNumberInCategory;
import com.lazyProgrammer.blog.model.Post;

import java.util.List;

public interface PostService {
    PostRequest save(PostRequest post);
    List<PostListResponse> getAll();
    PostDetailResponse getPostDetail(Long id);
    Post getById(Long postId);
    List<PostNumberInCategory> postCategoryCount();
}
