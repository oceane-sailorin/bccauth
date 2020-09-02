package com.bccauth.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "authusers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Authuser implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authuser_id", nullable = false)
    private long id;
    @Column(name = "authuser_login")
    private String login;
    @Column(name = "authuser_password")
    @JsonIgnore
    private String password;
  
   
}
