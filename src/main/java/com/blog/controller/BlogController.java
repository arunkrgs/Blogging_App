package com.blog.controller;

import com.blog.dto.CommentDto;
import com.blog.dto.PostDto;
import com.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BlogController {
    private PostService postService;

    public BlogController(PostService postService) {
        this.postService = postService;
    }

// handler method to handle http://localhost:8080/
    @GetMapping("/")
    public String viewBlogPosts(Model model){
        List<PostDto> postsResponse = postService.findAllPosts();
        List<PostDto> sortedResponse = postsResponse.stream().sorted(Comparator.comparing(PostDto::getCreatedOn).reversed()).collect(Collectors.toList());
        model.addAttribute("postsResponse", sortedResponse);
        return "blog/view_posts";
    }


    // handler method to handle view post request
    @GetMapping("/post/{postUrl}")
    private String showPost(@PathVariable("postUrl") String postUrl, Model model){
        PostDto post = postService.findPostByUrl(postUrl);
        model.addAttribute("post", post);
        CommentDto commentDto  = new CommentDto();
        model.addAttribute("comment", commentDto);
        return "blog/blog_post";
    }

}
