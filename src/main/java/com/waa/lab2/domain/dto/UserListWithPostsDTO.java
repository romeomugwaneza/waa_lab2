package com.waa.lab2.domain.dto;

import lombok.Data;

import java.util.List;
@Data
public class UserListWithPostsDTO {
    private List<UserDTO> userList;
}
