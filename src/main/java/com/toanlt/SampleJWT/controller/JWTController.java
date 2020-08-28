package com.toanlt.SampleJWT.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.toanlt.SampleJWT.jwt.JwtTokenProvider;
import com.toanlt.SampleJWT.model.CustomUserDetails;
import com.toanlt.SampleJWT.model.LoginRequest;
import com.toanlt.SampleJWT.model.LoginResponse;

@RestController
@RequestMapping("/api")
public class JWTController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@PostMapping("/login")
//	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	private LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		System.out.println("Connect OK");
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Trả về jwt cho người dùng.
		String jwt = jwtTokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
		return new LoginResponse(jwt);
	}
}
