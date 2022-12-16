package com.iqbalnetwork.controllers;

import com.iqbalnetwork.entities.Credential;
import com.iqbalnetwork.model.AuthResponse;
import com.iqbalnetwork.model.LoginRequest;
import com.iqbalnetwork.model.RegisterRequest;
import com.iqbalnetwork.services.interfaces.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/auth")
public class CredentialController {
    @Autowired
    UserEntityService service;

    @PostMapping("register")
    public ResponseEntity register(@Valid @RequestBody RegisterRequest request) throws Exception {
        Credential credential = service.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(credential);
    }

    @PostMapping("login")
    public ResponseEntity login(@Valid @RequestBody LoginRequest request) throws Exception {
        AuthResponse authentication = service.login(request);
        return ResponseEntity.status(HttpStatus.OK).body(authentication);
    }
}
