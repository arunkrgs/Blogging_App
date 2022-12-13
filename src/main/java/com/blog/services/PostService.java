package com.blog.services;

import com.blog.dto.PostDto;

import java.util.List;

public interface PostService {

        List<PostDto> findAllPosts();
}
