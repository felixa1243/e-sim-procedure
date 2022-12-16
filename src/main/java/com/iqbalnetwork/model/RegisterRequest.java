package com.iqbalnetwork.model;

import com.iqbalnetwork.entities.UserEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class RegisterRequest {
    @NotEmpty
    private String username;
    @Email
    private String email;
    @Length(min = 6)
    private String password;
    @Length(min = 6)
    private String passwordVerification;
    private UserEntity user;
}
