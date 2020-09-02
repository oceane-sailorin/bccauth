package com.bccauth.adapters.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bccauth.models.entities.Authuser;

@Repository
public interface AuthuserDao extends CrudRepository<Authuser, Integer> {
    Authuser findByLogin(String login);
}
