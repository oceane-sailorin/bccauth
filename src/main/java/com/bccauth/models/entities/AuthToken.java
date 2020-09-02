package com.bccauth.models.entities;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthToken {
	
	private String token;
	private String login;

    public AuthToken(){

    }

    public AuthToken(String token){
        this.token = token;
    }
    
    public AuthToken(String token, String login){
        this.token = token;
        this.login = login;
    }
}
