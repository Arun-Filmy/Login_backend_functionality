package com.LoginFunctionalityWork.service;

import com.LoginFunctionalityWork.dto.UserDto;
import com.LoginFunctionalityWork.entity.UserDetails;

import java.util.List;

public interface UserService {
    UserDetails findByEmail(String email);

    List<UserDto> findAllUsers();
    public boolean validateUser(String email, String password);
}
