package com.iqbalnetwork.controllers;

import com.iqbalnetwork.model.DrivingLicenseRequest;
import com.iqbalnetwork.utils.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/driving-license")
public class DrivingLicenseController {
    @Autowired
    JwtGenerator jwtGenerator;
    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping("register")
    public ResponseEntity register(@RequestBody DrivingLicenseRequest request) {
        String username = jwtGenerator.getUsername(request.getToken());
        UserDetails user = userDetailsService.loadUserByUsername(username);
        System.out.println(user);
        return ResponseEntity.ok(user);
    }
}
