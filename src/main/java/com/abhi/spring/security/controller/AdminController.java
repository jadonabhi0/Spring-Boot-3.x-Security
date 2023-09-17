package com.abhi.spring.security.controller;/*
    @author jadon
*/

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/home")
    public String home(){
        return "This is admin home handler";
    }


    @GetMapping("/login")
    public String login(){
        return "This is admin login handler";
    }

    @GetMapping("/register")
    public String register(){
        return "This is admin register handler";
    }

}
