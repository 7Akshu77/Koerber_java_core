package com.demo.bookapp.service;

import com.demo.bookapp.dto.UserEntity;

public interface UserService {
    public UserEntity findByUsername(String username);
    public void addUserEntity(UserEntity userEntity);
}
