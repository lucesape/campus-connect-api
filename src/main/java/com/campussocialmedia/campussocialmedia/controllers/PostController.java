package com.campussocialmedia.campussocialmedia.controllers;

import java.util.List;

import com.campussocialmedia.campussocialmedia.entity.Post;
import com.campussocialmedia.campussocialmedia.entity.PostCreationRequest;
import com.campussocialmedia.campussocialmedia.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PostController {

    @Autowired
    private PostService service;

    /*
     * This endpoint is for creating new posts. The user will send a form-data
     * (PostCreationRequest).
     */
    @PostMapping("/post")
    public ResponseEntity<?> addPost(@ModelAttribute PostCreationRequest post) {
        Post newPost = service.addPost(post);
        return new ResponseEntity<>(newPost, HttpStatus.OK);
    }

    /*
     * This endpoint is to get the Post Entity using the unique "postID"
     */
    @GetMapping("/post/{postID}")
    public ResponseEntity<Post> findPostByID(@PathVariable String postID) {
        Post post = service.findPostByID(postID);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    /*
     * This endpoint is to get all the posts created by a user using the userName
     */
    @GetMapping("/posts/{userName}")
    public ResponseEntity<?> findPostsByUserName(@PathVariable String userName) {
        List<Post> posts = service.findPostsByUserName(userName);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

}
