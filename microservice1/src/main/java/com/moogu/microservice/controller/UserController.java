package com.moogu.microservice.controller;

import com.moogu.microservice.model.User;
import com.moogu.microservice.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String getUser(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/user")
    public String saveUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "result";
    }
}
