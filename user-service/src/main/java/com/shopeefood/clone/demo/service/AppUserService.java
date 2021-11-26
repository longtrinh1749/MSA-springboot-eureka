package com.shopeefood.clone.demo.service;

import com.shopeefood.clone.demo.entity.AppUser;
import com.shopeefood.clone.demo.payload.RegisterForm;

public interface AppUserService {

    AppUser register(RegisterForm registerForm);

    Boolean checkUsernameExisted(String username);
}
