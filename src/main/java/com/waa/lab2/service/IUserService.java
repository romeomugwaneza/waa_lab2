package com.waa.lab2.service;

import com.waa.lab2.domain.Post;
import com.waa.lab2.domain.User;
import com.waa.lab2.domain.dto.PostDTO;
import com.waa.lab2.domain.dto.request.UserRequest;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void save(UserRequest userRequest);

    User findById(long userId);

    void addPost(long userId, PostDTO post);
    List<Post> getPosts(long userId);

    List<User> findUsersByPostsSizeGreaterThan(int numberOfPosts);
}
