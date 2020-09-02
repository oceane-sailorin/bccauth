package com.bccauth.services;

import com.bccauth.models.entities.Authuser;

public interface AuthuserManager {
	
	 Authuser findOne(String login);
}
