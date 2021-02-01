package com.home.ExpensesControl.securityDemo.basicAuthDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicAuthSecurePageController {
    @GetMapping("/basicAuthSecurePage")
    public String getBasicAuthSecurePage() {
        return "basicAuthSecurePage";
    }
}
