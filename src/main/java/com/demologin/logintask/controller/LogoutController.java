package com.demologin.logintask.controller;

import com.demologin.logintask.service.LoginServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String showLogoutpageForm(){
        if(LoginServiceImpl.token!=null){
            return "logout";
        }
        return "redirect:/login";
    }
    @GetMapping("/logout_submit")
    public String showLoginpageForm(){
        LoginServiceImpl.token=null;
        return "redirect:/login";
    }
}
