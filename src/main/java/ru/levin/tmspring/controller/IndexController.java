package ru.levin.tmspring.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String getIndex(Model model) {
        @NotNull final String message = "Hello, bobah!";
        model.addAttribute("message", message);
        return "index";
    }

}
