package com.restapijwt.crudjwt.services;

import com.restapijwt.crudjwt.entity.Role;
import com.restapijwt.crudjwt.entity.Users;
import com.restapijwt.crudjwt.repository.UserRepository;
import com.restapijwt.crudjwt.request.SignInRequest;
import com.restapijwt.crudjwt.request.SignUpRequest;
import com.restapijwt.crudjwt.response.ResponseApi;
import com.restapijwt.crudjwt.response.SignInResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthInterface{

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Override
    public ResponseEntity<SignInResponse> signIn(SignInRequest signInRequest) {
        Optional<Users> checkuser=userRepository.findByUsername(signInRequest.getUsername());
        if(checkuser.isEmpty()){
            return new ResponseEntity<>(new SignInResponse("Login Gagal",false,null,null), HttpStatus.OK);
        }
        Users user=userRepository.findByUsername(signInRequest.getUsername()).orElseThrow();
        var jwt=jwtService.generateToken(user);
        var refreshToken=jwtService.generateRefreshToken(new HashMap<>(),user);
        user.setRefreshToken(refreshToken);
        user.setToken(jwt);
        userRepository.save(user);
        return new ResponseEntity<>(new SignInResponse("Login Success",true,jwt,refreshToken), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi> signUp(SignUpRequest request) {
        Users user = new Users();
        user.setRole(Role.ADMIN);
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setAddress(request.getAdress());
        user.setToken("not set");
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setRefreshToken("not set");
        userRepository.save(user);
        return new ResponseEntity<>(new ResponseApi("success",true), HttpStatus.OK);
    }
}
