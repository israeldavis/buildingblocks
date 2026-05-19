package com.simplify.restservices.controllers;

import com.simplify.restservices.dtos.UserMsDto;
import com.simplify.restservices.mappers.UserMapper;
import com.simplify.restservices.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.simplify.restservices.entities.User;

@RestController
@RequestMapping("/mapstruct/users")
public class UserMapStructController {

    private UserService userService;
    private UserMapper userMapper;

    public UserMapStructController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserMsDto> getAllUserDtos() {
        return this.userMapper.usersToUserDtos(this.userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public UserMsDto getUserByid(@PathVariable("id") Long id){
        User user = this.userService.getUserById(id);

        return userMapper.userToUserMsDto(user);

    }

}
