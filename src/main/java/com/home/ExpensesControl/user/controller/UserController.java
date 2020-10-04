package com.home.ExpensesControl.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") long id) {
        System.out.println("user controller invoked!");
        return "user controller invoked!";
    }
}
