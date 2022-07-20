package com.example.SpringDemoApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="userRole")
public class UserRoleController {

    @GetMapping(value="/403")
    public String accessDenied(Model model) {
        return null;
    }

    @GetMapping(value="/login")
    public String login(Model model) {
        return null;
    }

}
