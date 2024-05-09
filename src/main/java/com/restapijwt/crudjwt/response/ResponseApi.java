package com.restapijwt.crudjwt.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ResponseApi {
    private String message;
    private Boolean success;
}
