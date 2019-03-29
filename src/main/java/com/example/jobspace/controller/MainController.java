package com.example.jobspace.controller;

import com.example.jobspace.model.UserType;
import com.example.jobspace.security.SpringUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/worker")
    public String workerPage(ModelMap modelMap,
                           @AuthenticationPrincipal
                                   SpringUser springUser) {
        modelMap.addAttribute("worker", springUser.getUser());
        return "worker";
    }

    @GetMapping("/employer")
    public String employerPage() {
        return "employer";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess(@AuthenticationPrincipal
                                       SpringUser springUser) {
        if (springUser.getUser().getUserType() == UserType.EMPLOYER) {
            return "redirect:/employer";
        }
        return "redirect:/worker";

    }
}
