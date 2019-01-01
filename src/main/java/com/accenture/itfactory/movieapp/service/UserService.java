package com.accenture.itfactory.movieapp.service;

import com.accenture.itfactory.movieapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserService extends CrudRepository<User, Long> {
//    void registerUser(String login, String name, String passWord, String userType);
//
//    void loginUser(String login, String passWord);

}
