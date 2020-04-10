package com.vegedog.springboog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HelloController {

    @RequestMapping("/abc")
    //@GetMapping("/abc")
    public String hello(Model model) {
        model.addAttribute("msg", "你好！");
        return "success";
    }
}
