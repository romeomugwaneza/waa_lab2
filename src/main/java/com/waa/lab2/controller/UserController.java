package com.waa.lab2.controller;

import com.waa.lab2.domain.User;
import com.waa.lab2.domain.dto.PostDTO;
import com.waa.lab2.domain.dto.request.UserRequest;
import com.waa.lab2.domain.dto.response.Posts;
import com.waa.lab2.domain.dto.response.Users;
import com.waa.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(value = "min_posts", required = false) Integer min_posts){

        Users users = new Users();

        if (min_posts != null){

            users.setUsers(userService.findUsersByPostsSizeGreaterThan(min_posts));
            return ResponseEntity.ok().body(users);

        }

        users.setUsers(userService.findAll());

        return ResponseEntity.ok().body(users);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody UserRequest userRequest){

        userService.save(userRequest);

    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") long userId){
        try {

            return ResponseEntity.ok().body(userService.findById(userId));

        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{userId}/posts")
    public void addPost(
            @PathVariable("userId") long userId,
            @RequestBody PostDTO post){

        userService.addPost(userId, post);

    }

    @GetMapping("/{userId}/posts")
    public ResponseEntity<?> getPost(@PathVariable("userId") long userId){

        try {
            Posts posts = new Posts();
            posts.setPosts(userService.getPosts(userId));
            return ResponseEntity.ok().body(posts);
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.notFound().build();

    }


}
