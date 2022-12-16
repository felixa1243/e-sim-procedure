package com.iqbalnetwork.services;

import com.iqbalnetwork.entities.Credential;
import com.iqbalnetwork.entities.Roles;
import com.iqbalnetwork.entities.UserEntity;
import com.iqbalnetwork.model.AuthResponse;
import com.iqbalnetwork.model.LoginRequest;
import com.iqbalnetwork.model.RegisterRequest;
import com.iqbalnetwork.repositories.interfaces.CredentialRepository;
import com.iqbalnetwork.repositories.interfaces.RoleRepository;
import com.iqbalnetwork.services.interfaces.UserEntityService;
import com.iqbalnetwork.utils.JwtGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserEntityServiceImpl implements UserEntityService {
    @Autowired
    CredentialRepository repository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtGenerator jwtGenerator;

    @Override
    public Credential register(RegisterRequest request) throws Exception {
        Credential credential = mapper.map(request, Credential.class);
        UserEntity user = mapper.map(request, UserEntity.class);
        Roles roles = roleRepository.findByName("USER").get();
        credential.getRoles().add(roles);
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        return repository.save(credential);
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new AuthResponse(token);
    }
}
