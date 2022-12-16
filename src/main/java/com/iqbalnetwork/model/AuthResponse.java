package com.iqbalnetwork.model;

import lombok.Data;

@Data
public class AuthResponse {
    private String accessToken;
    private String token_type;
    public AuthResponse(String accessToken){
        this.accessToken = accessToken;
    }
}
