package com.gllllepulla.transfer;

import com.gllllepulla.model.Dto;
import com.gllllepulla.model.Info;

import java.util.Optional;

public interface UserTransferService {
    Optional<Dto.BookishUser> addUser(Info.BookishUser user);

}
