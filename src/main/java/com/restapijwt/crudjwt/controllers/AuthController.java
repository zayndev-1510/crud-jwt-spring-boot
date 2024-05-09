package com.restapijwt.crudjwt.controllers;


import com.restapijwt.crudjwt.request.SignInRequest;
import com.restapijwt.crudjwt.request.SignUpRequest;
import com.restapijwt.crudjwt.response.ResponseApi;
import com.restapijwt.crudjwt.response.SignInResponse;
import com.restapijwt.crudjwt.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    @GetMapping("welcome")
    public String welcome() {
        return "Welcome to REST API JWT";
    }
    private final AuthService authService;
   @PostMapping(value = "create-admin",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseApi> createAdmin(@Valid @RequestBody SignUpRequest signUpRequest) {
       return authService.signUp(signUpRequest);
   }

   @PostMapping(value = "sign-in",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SignInResponse> signIn(@Valid @RequestBody SignInRequest signInRequest) {
       return authService.signIn(signInRequest);
   }
}
