package com.home.ExpensesControl.securityDemo.formAuthDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormAuthSecurePageController {
    @GetMapping("/formAuthSecurePage")
    public String getFormAuthSecurePage() {
        return "formAuthSecurePage";
    }
}
