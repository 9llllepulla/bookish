package com.gllllepulla.service;


import com.gllllepulla.model.Dto;
import com.gllllepulla.model.Info;

import java.util.Optional;

public interface UserService {

    Optional<Dto.BookishUser> findUserByName(String username);

    Optional<Info.BookishUser> addUser(Info.BookishUser userForm);

}
