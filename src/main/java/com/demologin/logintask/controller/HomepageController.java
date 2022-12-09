package com.demologin.logintask.controller;

import com.demologin.logintask.service.LoginServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController{

    @GetMapping("/homepage")
    public String showHomepageForm(){
        if(LoginServiceImpl.token!=null){
            return "homepage";
        }
        return "redirect:/login";
    }
}
