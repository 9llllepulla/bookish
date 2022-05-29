package com.gllllepulla.service.impl;

import com.gllllepulla.model.Dto;
import com.gllllepulla.service.UserService;
import com.gllllepulla.service.UserServiceProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Security service provider of user
 */
@RequiredArgsConstructor
@Slf4j
@Service
class UserServiceProviderImpl implements UserServiceProvider {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Dto.User user = userService.findUserByName(username)
                .orElseThrow(() -> {
                    log.error("user with name {} not found", username);
                    return new UsernameNotFoundException("user with name "+username+" not found");
                });
        return new UserWithDetails(user);
    }

}
