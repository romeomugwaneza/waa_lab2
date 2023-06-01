package com.waa.lab2.domain.dto.response;

import com.waa.lab2.domain.Post;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Posts {
    private List<Post> posts = new ArrayList<>();
}
