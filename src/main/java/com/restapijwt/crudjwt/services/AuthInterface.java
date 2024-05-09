package com.restapijwt.crudjwt.services;

import com.restapijwt.crudjwt.request.SignInRequest;
import com.restapijwt.crudjwt.request.SignUpRequest;
import com.restapijwt.crudjwt.response.ResponseApi;
import com.restapijwt.crudjwt.response.SignInResponse;
import org.springframework.http.ResponseEntity;

public interface AuthInterface {
    ResponseEntity<SignInResponse> signIn(SignInRequest signInRequest);
    ResponseEntity<ResponseApi> signUp(SignUpRequest signUpRequest);
}
