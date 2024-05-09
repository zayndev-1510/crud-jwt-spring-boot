package com.restapijwt.crudjwt.services;

import com.restapijwt.crudjwt.request.SignUpRequest;
import com.restapijwt.crudjwt.response.ResponseApi;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserInterface {
    UserDetailsService getUserDetailsService();
}
