package com.demologin.logintask.controller;

//import com.demologin.logintask.config.PasswordEncodeUtil;
import com.demologin.logintask.entity.User;
import com.demologin.logintask.repository.UserRepository;
import com.demologin.logintask.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class SignUpController {

    @Autowired
    private UserRepository userRepo;
//    @Autowired
//    private PasswordEncodeUtil bcryptEncoder;
    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @GetMapping("/signup")
    public String showSignUpForm(Model model){
        model.addAttribute("user", new User());
        return "signupform";
    }
    @PostMapping (path = "/signup_submit")
    public String saveUserToDB(@RequestParam String email, @RequestParam String password,
                                                   @RequestParam String first_name){
        User user = new User(email.trim(),password.trim(),first_name.trim());
        return loginServiceImpl.validateEmail(user);
    }
}
