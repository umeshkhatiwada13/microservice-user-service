package com.user.userservice.service;

import com.user.userservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    List<User> userList = List.of(
            new User(1, "Ram", "111111"),
            new User(2, "Sita", "222222"),
            new User(3, "Hari", "333333")
    );

    @Override
    public User getById(int id) {
        return userList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
}
