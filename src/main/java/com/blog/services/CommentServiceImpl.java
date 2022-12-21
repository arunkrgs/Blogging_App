package com.blog.services;

import com.blog.dto.CommentDto;
import com.blog.entities.Comment;
import com.blog.entities.Post;
import com.blog.mapper.CommentMapper;
import com.blog.repositories.CommentRepository;
import com.blog.repositories.PostRepository;
import com.blog.repositories.CommentRepository;
import com.blog.repositories.PostRepository;
import com.blog.services.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {


    private CommentRepository commentRepository;
    private PostRepository postRepository;


    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void createComment(String postUrl, CommentDto commentDto) {
        Post post = postRepository.findByUrl(postUrl).get();
        Comment comment = CommentMapper.mapToComment(commentDto);
        comment.setPost(post);
        commentRepository.save(comment);
    }
}
