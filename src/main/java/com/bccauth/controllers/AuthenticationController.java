package com.bccauth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.bccauth.TokenProvider;
import com.bccauth.models.LoginAuthuser;
import com.bccauth.models.entities.ApiResponse;
import com.bccauth.models.entities.AuthToken;
import com.bccauth.models.entities.Authuser;
import com.bccauth.services.AuthuserManager;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {
   
	    @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private TokenProvider jwtTokenUtil;
	   
	    @Autowired
	    private AuthuserManager authuserManager;

	    @PostMapping(value = "/generate-token")
	  
        public ApiResponse<AuthToken> register(@RequestBody LoginAuthuser loginAuthuser)  {

	        final Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                		loginAuthuser.getLogin(),
	                		loginAuthuser.getPassword()
	                )
	        );
	    	SecurityContextHolder.getContext().setAuthentication(authentication);
	        final String token = jwtTokenUtil.generateToken(authentication);
	        final Authuser authuser = authuserManager.findOne(loginAuthuser.getLogin());
	        return new ApiResponse<>(200, "success",new AuthToken(token, authuser.getLogin()));	    
        }
	    
	  
	}
