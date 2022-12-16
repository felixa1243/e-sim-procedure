package com.iqbalnetwork.services.interfaces;

import com.iqbalnetwork.entities.Credential;
import com.iqbalnetwork.model.AuthResponse;
import com.iqbalnetwork.model.LoginRequest;
import com.iqbalnetwork.model.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserEntityService {
    Credential register(RegisterRequest request) throws Exception;
    AuthResponse login(LoginRequest request)throws Exception;
}
