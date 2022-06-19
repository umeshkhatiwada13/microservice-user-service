package com.user.userservice.controller;

import com.user.userservice.entity.User;
import com.user.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{id}")
    public User getUserDetails(@PathVariable Integer id) {
        System.out.println("Getting user data with id " + id);
        List contacts = restTemplate.getForObject("http://contact-service/contact/user/" + id, List.class);
        System.out.println("Contacts from restTemplate " + contacts.toString());
        User user = userService.getById(id);
        user.setContacts(contacts);
        return user;
    }
}
