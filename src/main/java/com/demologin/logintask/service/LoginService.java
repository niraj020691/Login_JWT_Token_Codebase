package com.demologin.logintask.service;

import com.demologin.logintask.entity.User;

public interface LoginService {

    User loadUserByEmail(String email);
}
