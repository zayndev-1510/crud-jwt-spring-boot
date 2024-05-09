package com.restapijwt.crudjwt.services;

import com.restapijwt.crudjwt.entity.Role;
import com.restapijwt.crudjwt.entity.Users;
import com.restapijwt.crudjwt.repository.UserRepository;
import com.restapijwt.crudjwt.request.SignUpRequest;
import com.restapijwt.crudjwt.response.ResponseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService  implements UserInterface{
    private final UserRepository userRepository;
    @Override
    public UserDetailsService getUserDetailsService() {
        return username -> userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
