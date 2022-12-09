package com.demologin.logintask.controller;

import com.demologin.logintask.entity.User;
import com.demologin.logintask.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @GetMapping("/login")
    public String showSignUpForm(Model model){
        model.addAttribute("user", new User());
        return "loginform";
    }

    @PostMapping (path = "/login_submit")
    public String validateUser(@RequestParam String email, @RequestParam String password) {
        User user = new User(email.trim(), password.trim());
        return  loginServiceImpl.validateLogin(user);
    }
}
