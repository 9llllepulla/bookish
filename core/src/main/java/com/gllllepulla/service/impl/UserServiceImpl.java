package com.gllllepulla.service.impl;

import com.gllllepulla.mapper.UserMapper;
import com.gllllepulla.model.Dto;
import com.gllllepulla.model.Info;
import com.gllllepulla.service.UserService;
import com.gllllepulla.transfer.UserTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
class UserServiceImpl implements UserService {

    private final UserTransferService userTransferService;
    private final UserMapper userMapper;

    @Override
    public Optional<Dto.BookishUser> findUserByName(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<Info.BookishUser> addUser(Info.BookishUser userForm) {
        return userTransferService.addUser(userForm)
                .map(userMapper::toUserInfo);
    }
}
