package com.chengp.blog.controller;

import com.chengp.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pc on 2/24/16.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public String users(Model model) {

        model.addAttribute("users", userService.findAll());
        return "users";
    }
}
