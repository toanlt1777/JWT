package com.toanlt.SampleJWT.model;

import lombok.Data;

/**
 * Copyright 2019 {@author Loda} (https://loda.me). This project is licensed
 * under the MIT license.
 */
@Data
public class LoginResponse {
	private String accessToken;
    private String tokenType = "Bearer";

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}