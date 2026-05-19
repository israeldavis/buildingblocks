package com.simplify.restservices.controllers;

import com.simplify.restservices.dtos.UserMmDto;
import com.simplify.restservices.entities.User;
import com.simplify.restservices.services.UserService;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/modelmapper/users")
public class UserModelMapperController {

    private UserService userService;
    private ModelMapper modelMapper;

    public UserModelMapperController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public UserMmDto getUserById(@PathVariable("id") @Min(1) Long id) {
        User user = this.userService.getUserById(id);

        UserMmDto userMmDto = this.modelMapper.map(user, UserMmDto.class);

        return userMmDto;
    }
}
