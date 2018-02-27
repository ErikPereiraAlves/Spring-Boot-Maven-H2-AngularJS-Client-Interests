package com.erikalves.application.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebAppController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebAppController.class);

    @RequestMapping("/")
    String home(ModelMap modal) {
        modal.addAttribute("title","Erik Alves - Users register application");
        return "index";
    }

    @RequestMapping("/partials/{page}")
    String partialHandler(@PathVariable("page") final String page) {
        return page;
    }


}

