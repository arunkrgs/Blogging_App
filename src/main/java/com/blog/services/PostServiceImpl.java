package com.blog.services;

import com.blog.dto.PostDto;
import com.blog.entities.Post;
import com.blog.mapper.PostMapper;
import com.blog.repositories.PostRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

//Constructor based injection
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDto> findAllPosts() {
        List<Post> posts = postRepository.findAll();// Takes all data from DB Push that into Entity class objects
        return posts.stream().map(PostMapper::mapToPostDto).collect(Collectors.toList());//Here Convert Entity <Post> to <PostDto>
   }
}
