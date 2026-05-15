package com.simplify.restservices.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.simplify.restservices.entities.User;
import com.simplify.restservices.entities.Views;
import com.simplify.restservices.services.UserService;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/jsonview/users")
public class UserJsonViewController {

    private UserService userService;

    public UserJsonViewController (UserService userService) {
        this.userService = userService;
    }

    @JsonView(Views.External.class)
    @GetMapping("/external/{id}")
    public ResponseEntity<User> getUserExternalById(@PathVariable @Min(1) Long id) {
        return new ResponseEntity<>(this.userService.getUserById(id), HttpStatus.OK);
    }

    @JsonView(Views.Internal.class)
    @GetMapping("/internal/{id}")
    public ResponseEntity<User> getUserInternalById(@PathVariable @Min(1) Long id) {
        return new ResponseEntity<>(this.userService.getUserById(id), HttpStatus.OK);
    }


}
