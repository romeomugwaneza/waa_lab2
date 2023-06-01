package com.waa.lab2.service;


import com.waa.lab2.domain.Post;
import com.waa.lab2.domain.User;
import com.waa.lab2.domain.dto.PostDTO;
import com.waa.lab2.domain.dto.request.UserRequest;
import com.waa.lab2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> findAll() {

        return userRepository.findAll();

    }

    @Override
    public void save(UserRequest userRequest) {

        User newUser = new User();

        newUser.setName(userRequest.getName());

        userRepository.save(newUser);

    }

    @Override
    public User findById(long userId) throws NoSuchElementException{

        return userRepository.findById(userId).orElseThrow();

    }

    @Override
    public void addPost(long userId, PostDTO post) throws NoSuchElementException {



        User userFound = userRepository.findById(userId).orElseThrow();

        Post postToAdd = new Post();

        postToAdd.setTitle(post.getTitle());
        postToAdd.setContent(post.getContent());

        userFound.addPost(postToAdd);

        userRepository.save(userFound);

    }

    @Override
    public List<Post> getPosts(long userId) throws NoSuchElementException {

        User userFound = userRepository.findById(userId).orElseThrow();

        return userFound.getPosts();
    }

    @Override
    public List<User> findUsersByPostsSizeGreaterThan(int numberOfPosts) {
        return userRepository.findByPostsSizeGreaterThan(numberOfPosts);
    }


}
