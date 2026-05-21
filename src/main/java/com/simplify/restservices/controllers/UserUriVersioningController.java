package com.simplify.restservices.controllers;

import com.simplify.restservices.dtos.UserDtoV1;
import com.simplify.restservices.dtos.UserDtoV2;
import com.simplify.restservices.dtos.UserMmDto;
import com.simplify.restservices.entities.User;
import com.simplify.restservices.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/versioning/uri/users")
public class UserUriVersioningController {

    private UserService userService;
    private ModelMapper modelMapper;

    public UserUriVersioningController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping({"/v1.0/{id}", "/v1.1/{id}"})
    public UserDtoV1 getUserById(@PathVariable("id") Long id) {
        User user = this.userService.getUserById(id);
        UserDtoV1 userDtoV1 = modelMapper.map(user, UserDtoV1.class);
        return userDtoV1;
    }

    @GetMapping("/v2.0/{id}")
    public UserDtoV2 getUserByIdV2(@PathVariable("id") Long id) {
        User user = this.userService.getUserById(id);
        UserDtoV2 userDtoV2 = modelMapper.map(user, UserDtoV2.class);
        return userDtoV2;
    }

}
