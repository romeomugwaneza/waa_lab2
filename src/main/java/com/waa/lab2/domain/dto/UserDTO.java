package com.waa.lab2.domain.dto;

import com.waa.lab2.domain.Post;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private long userId;
    private String name;
    private List<Post> posts;

}
