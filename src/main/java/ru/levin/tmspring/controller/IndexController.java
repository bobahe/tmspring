package ru.levin.tmspring.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView getIndex() {
        @NotNull final String message = "Hello, bobah!";
        return new ModelAndView("index", "message", message);
    }

}
