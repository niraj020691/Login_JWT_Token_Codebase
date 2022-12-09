package com.demologin.logintask.service;

import com.demologin.logintask.entity.User;
import com.demologin.logintask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    public static String token = null;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginJwt loginJwt;

    public String validateLogin(User user1) {
        if(loadUserByEmail(user1.getEmail())!=null) {
            if (loadUserByEmail(user1.getEmail()).getPassword().equalsIgnoreCase(user1.getPassword())) {
                token = loginJwt.generateToken(user1.getEmail());
                System.out.println("JWT TOKEN GENERATED : "+token);
                return "redirect:/homepage";
            }else{
                return "redirect:/login";
            }
        }else {
            return "redirect:/signup";
        }
    }
    public String validateEmail(User check_email){
        if(loadUserByEmail(check_email.getEmail())!=null){
            return "redirect:/signup";
        }
        userRepository.save(check_email);
        return "redirect:/login";
    }
    @Override
    public User loadUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
