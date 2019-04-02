package com.example.jobspace.controller;

import com.example.jobspace.model.User;
import com.example.jobspace.model.UserType;
import com.example.jobspace.security.SpringUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public String workerPage() {
        return "worker";
    }

    @GetMapping("/employer")
    public String employerPage() {
        return "employer";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess(@AuthenticationPrincipal
                                       SpringUser springUser,HttpServletRequest request) {
        request.getSession().setAttribute("user",springUser);
        if (springUser.getUser().getUserType() == UserType.EMPLOYER) {
            return "redirect:/employer";
        }

        return "redirect:/";

    }
}
