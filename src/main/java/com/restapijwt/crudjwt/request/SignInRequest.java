package com.restapijwt.crudjwt.request;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignInRequest {

    @NotBlank(message = "Username tidak boleh ksoong")
    private String username;
    @NotBlank(message ="Paasword tidak boleh kosong")
    private String password;

}
