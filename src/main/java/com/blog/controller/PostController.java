package com.blog.controller;

import com.blog.dto.PostDto;
import com.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PostController {

        private PostService postService;

        public PostController(PostService postService){
            this.postService = postService;
        }

// http://localhost:8080/admin/posts
        @GetMapping("/admin/posts")
        public String posts(Model model){
            List<PostDto> posts = postService.findAllPosts();
            model.addAttribute("posts", posts);
            return "/admin/posts";
        }

// http://localhost:8080/admin/posts/newpost
        @GetMapping("/admin/posts/newpost")
        public String newPostForm(Model model){
            PostDto postDto = new PostDto();
            model.addAttribute("post", postDto);
            return "admin/create_post";
        }
}
