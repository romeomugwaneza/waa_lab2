package com.waa.lab2.domain.dto.response;

import com.waa.lab2.domain.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Users {
    private List<User> users = new ArrayList<>();
}
