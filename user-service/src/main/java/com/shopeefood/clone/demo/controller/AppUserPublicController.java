package com.shopeefood.clone.demo.controller;

import com.shopeefood.clone.demo.entity.AppUser;
import com.shopeefood.clone.demo.payload.RegisterForm;
import com.shopeefood.clone.demo.repository.AppUserRepository;
import com.shopeefood.clone.demo.response.JsonResult;
import com.shopeefood.clone.demo.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/public")
public class AppUserPublicController {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    AppUserService appUserService;

    @PostMapping(value = "/register", consumes = {"multipart/form-data", "application/json"})
    public ResponseEntity<JsonResult> register(@RequestBody RegisterForm registerForm) {
        if (appUserService.checkUsernameExisted(registerForm.getUsername()))
            return ResponseEntity.ok(JsonResult.build("Register failed", "Username existed"));
        AppUser appUser = appUserService.register(registerForm);
        if (appUser != null) {
            appUser.setPassword(null);
            return ResponseEntity.ok(JsonResult.build("Register succeed", appUser));
        }
        return ResponseEntity.badRequest().build();
    }

}
