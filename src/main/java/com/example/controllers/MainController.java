package com.example.controllers;

import com.example.domain.CustomUser;
import com.example.domain.Views;
import com.example.repository.UserRepos;
import com.example.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    private final UserService userService;
    private final UserRepos userRepos;

    public MainController(UserService userService, UserRepos userRepos) {
        this.userService = userService;
        this.userRepos = userRepos;
    }

    @JsonView(Views.Public.class)
    @GetMapping("/hello")
    List<CustomUser> main(){
        CustomUser user = userService.findByEmail("vova@gmail.com");
        List<CustomUser> users = userRepos.findAll();
        return users;
    }

    @JsonView(Views.Public.class)
    @PostMapping("/signUp")
    public CustomUser signUp(@RequestBody CustomUser customUser){
        userService.addUser(customUser);
        return userService.findByEmail(customUser.getEmail());
    }

    @JsonView(Views.Public.class)
    @PostMapping("/signIn")
    public CustomUser signIn(@RequestBody CustomUser customUser){
        return userService.findByEmail(customUser.getEmail());
    }
}
