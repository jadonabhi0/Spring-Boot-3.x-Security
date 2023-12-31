package com.abhi.spring.security.controller;/*
    @author jadon
*/

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/home")
    public String home(){
        return "Hello this is public home handler";
    }

    @GetMapping("/login")
    public String login(){
        return "Hello this is public login handler";
    }

    @GetMapping("/register")
    public String register(){
        return "Hello this is public register handler";
    }


}
