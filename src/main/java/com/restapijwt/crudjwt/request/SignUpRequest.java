package com.restapijwt.crudjwt.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignUpRequest {

    @NotBlank(message = "username can't blank")
    private String username;

    @NotBlank(message = "password can't blank")
    private String password;

    @Email(message = "email can't blank")
    private String email;


    @NotBlank(message = "firtname can't blank")
    private String firstname;
    @NotBlank(message = "lastname can't blank")
    private String lastname;
    @NotBlank(message = "address can't blank")
    private String adress;

}
