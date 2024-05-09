package com.restapijwt.crudjwt.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class SignInResponse {
    private String message;
    private Boolean success;
    private String token;
    private String refreshToken;
}
