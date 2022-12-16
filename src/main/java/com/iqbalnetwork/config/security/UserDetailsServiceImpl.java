package com.iqbalnetwork.config.security;

import com.iqbalnetwork.entities.Credential;
import com.iqbalnetwork.entities.Roles;
import com.iqbalnetwork.repositories.interfaces.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private CredentialRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Credential credential = repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return new User(credential.getUsername(), credential.getPassword(), mapRolesToAuthorities(credential.getRoles()));
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Roles> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
}
