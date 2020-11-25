package com.campussocialmedia.campussocialmedia.service;

import java.util.List;

import com.campussocialmedia.campussocialmedia.entity.Comment;
import com.campussocialmedia.campussocialmedia.repository.CommentRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository repository;

    public void addComment(String userName, Comment comment)
    {
        comment.setUserName(userName);
        repository.addComment(comment);
    }

    public List<Comment> getCommentsForPosts(String postID)
    {
        return repository.findCommentsByPostID(postID);
        
    }
}
