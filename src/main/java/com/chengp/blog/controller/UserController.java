package com.chengp.blog.controller;

import com.chengp.blog.entity.Blog;
import com.chengp.blog.entity.User;
import com.chengp.blog.service.BlogService;
import com.chengp.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by pc on 2/24/16.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @ModelAttribute("blog")
    public Blog constructBlog(){

        return new Blog();
    }

    @RequestMapping("/account")
    public String account(Model model, Principal principal) {

        String name = principal.getName();
        model.addAttribute("user", userService.findOneWithBlogs(name));
        return "account";
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String doAddBlog(Model model, @Valid @ModelAttribute("blog") Blog blog, Principal principal, BindingResult result) {

        if (result.hasErrors()) {

            String name = principal.getName();
            model.addAttribute("user", userService.findOneWithBlogs(name));
            return "account";
        }

        String name = principal.getName();
        blogService.save(blog, name);
        return "redirect:/account";
    }

    @RequestMapping("/blog/remove/{id}")
    public String removeBlog(@PathVariable int id) {

        Blog blog = blogService.findOne(id);
        blogService.delete(blog);
        return "redirect:/account";
    }

}
