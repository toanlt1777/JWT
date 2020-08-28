package com.toanlt.SampleJWT.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * Copyright 2019 {@author Loda} (https://loda.me). This project is licensed
 * under the MIT license.
 */
@Data
public class LoginRequest {
	@NotBlank
	private String username;

	@NotBlank
	private String password;
}