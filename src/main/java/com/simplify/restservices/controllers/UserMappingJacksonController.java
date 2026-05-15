package com.simplify.restservices.controllers;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.simplify.restservices.entities.User;
import com.simplify.restservices.services.UserService;
import jakarta.validation.constraints.Min;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/jacksonfilter/users")
@Validated
public class UserMappingJacksonController {

    private UserService userService;

    public UserMappingJacksonController (UserService userService) {
        this.userService = userService;
    }

    // fields with hasset
    @GetMapping("/{id}")
    public MappingJacksonValue getUserById(@PathVariable @Min(1) Long id) {
        User user = this.userService.getUserById(id);

        Set<String> fields = new HashSet<>();
        fields.add("id");
        fields.add("username");
        fields.add("ssn");
        fields.add("orders");

        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("userFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields));

        MappingJacksonValue mapper = new MappingJacksonValue(user);
        mapper.setFilters(filterProvider);
        return mapper;
    }

    // fields with @RequestParam
    @GetMapping("/params/{id}")
    public MappingJacksonValue getUserById2(@PathVariable @Min(1) Long id,
                                            @RequestParam("fields") Set<String> fields) {
        User user = this.userService.getUserById(id);


        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("userFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields));

        MappingJacksonValue mapper = new MappingJacksonValue(user);
        mapper.setFilters(filterProvider);
        return mapper;
    }
}
