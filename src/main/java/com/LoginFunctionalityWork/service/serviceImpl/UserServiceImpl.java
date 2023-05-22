package com.LoginFunctionalityWork.service.serviceImpl;

import com.LoginFunctionalityWork.dto.UserDto;
import com.LoginFunctionalityWork.repo.UserRepository;
import com.LoginFunctionalityWork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.LoginFunctionalityWork.entity.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails findByEmail(String email) {
        return (UserDetails) userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<com.LoginFunctionalityWork.entity.UserDetails> users = userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto((UserDetails) users))
                .collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(UserDetails user){
        UserDto userDto = new UserDto();
        String[] email = user.getEmail().split(" ");
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    @Override
    public boolean validateUser(String email, String password){
        List<UserDetails> details = userRepository.findByEmail(email);
        boolean b = (details != null) && details.get(0).getPassword().equals(password) && details.get(0).isEnabled();
        return b;
    }
}
