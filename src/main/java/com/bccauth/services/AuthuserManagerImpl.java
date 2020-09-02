package com.bccauth.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bccauth.adapters.interfaces.AuthuserDao;
import com.bccauth.models.entities.Authuser;

@Service(value = "authuserManager")	
public class AuthuserManagerImpl implements UserDetailsService, AuthuserManager {
	
	@Autowired
	private AuthuserDao authuserDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String login) {
		Authuser authuser = authuserDao.findByLogin(login);
		if(authuser == null){
			throw new UsernameNotFoundException("Invalid login or password.");
		}
		return new org.springframework.security.core.userdetails.User(authuser.getLogin(), authuser.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}


	@Override
	public Authuser findOne(String login) {
		return authuserDao.findByLogin(login);
	}

	
}
