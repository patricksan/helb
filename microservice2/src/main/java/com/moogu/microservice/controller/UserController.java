package com.moogu.microservice.controller;

import com.moogu.microservice.model.PageDetails;
import com.moogu.microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
        PageDetails pageDetails = new PageDetails();
        pageDetails.setGenerated(LocalDate.now());
        pageDetails.setUsers(userService.findAll());
        model.addAttribute("details", pageDetails);
        return "index";
    }

}
