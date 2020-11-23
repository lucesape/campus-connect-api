package com.campussocialmedia.campussocialmedia.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.campussocialmedia.campussocialmedia.entity.Post;
import com.campussocialmedia.campussocialmedia.entity.PostCreationRequest;
import com.campussocialmedia.campussocialmedia.repository.PostRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MediaService mediaService;

    private Post convertToPost(PostCreationRequest post) {
        return modelMapper.map(post, Post.class);
    }

    /*
     * Creating a Post is pretty straight-forward. Convert PostCreationRequest
     * object to the actual Post Object and then save it in the database. But we
     * also need to check if the user has provided a file in the CreationObject. If
     * yes, we need to upload it using "MediaService" and add the URL into the new
     * Post object.
     */
    public Post addPost(PostCreationRequest post) {
        Post convertedPost = convertToPost(post);
        convertedPost.setLikes(new HashSet<String>());
        if (post.getFile() != null) {
            // Upload this file.
            String url = mediaService.uploadFile(post.getFile());
            convertedPost.setUrl(url);
        }
        System.out.println("Hello");
        System.out.println(convertedPost);

        return repository.addPost(convertedPost);
    }

    public Post findPostByID(String postID) {
        return repository.findPostByID(postID);
    }

    public List<Post> findPostsByUserName(String userName) {
        return repository.findPostsByUserName(userName);
    }

    public List<Post> findAllPostsByUserNames(List<String> userNames) {
        List<Post> posts = new ArrayList<Post>();
        for (String userName : userNames) {
            posts.addAll(this.findPostsByUserName(userName));
        }
        return posts;
    }

    public void addLikeToPost(String userName, String postID)
    {
        Post post = repository.findPostByID(postID);
        Set<String> likeSet =  post.getLikes();
        System.out.println(likeSet);
        likeSet.add(userName);
        post.setLikes(likeSet);
        repository.updatePost(post);
    }

}
