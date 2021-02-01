package com.home.ExpensesControl.jspDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class JspController {
    @Value("${jsp.controller.message}")
    private String message;

    @GetMapping("/jspDemo")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "welcome";
    }
}
