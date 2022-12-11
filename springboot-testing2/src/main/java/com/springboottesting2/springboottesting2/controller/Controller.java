package com.springboottesting2.springboottesting2.controller;

import com.springboottesting2.springboottesting2.models.User;
import com.springboottesting2.springboottesting2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private UserService userService;

    Controller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    List<User> all() {
        return userService.FindAllUsers();
    }

    @PostMapping("/users")
    User newEmployee(@RequestBody User newUser) {
        return userService.SaveUser(newUser);
    }

    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) throws Exception {

        return userService.FindUserById(id);
    }

    @PutMapping("/users/{id}")
    User replaceEmployee(@RequestBody User newUser, @PathVariable Long id) {

        return userService.FindUserById(id);
    }

    @DeleteMapping("/users/{id}")
    void deleteEmployee(@PathVariable Long id) {
        userService.DeleteUser(id);
    }
}

