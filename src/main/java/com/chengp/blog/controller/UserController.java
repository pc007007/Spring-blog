package com.chengp.blog.controller;

import com.chengp.blog.entity.User;
import com.chengp.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by pc on 2/24/16.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User construct() {
        return new User();
    }

    @RequestMapping("/users")
    public String users(Model model) {

        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @RequestMapping("/users/{id}")
    public String detail(@PathVariable Integer id,Model model) {

        model.addAttribute("user", userService.findOneWithBlogs(id));

        return "user-detail";
    }

    @RequestMapping("/register")
    public String showRegister() {

        return "user-register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("user") User user) {

        userService.save(user);
        return "redirect:/register?success=true";
    }
}
