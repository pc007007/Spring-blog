package com.chengp.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pc on 2/22/16.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "/WEB-INF/views/index.jsp";
    }
}
