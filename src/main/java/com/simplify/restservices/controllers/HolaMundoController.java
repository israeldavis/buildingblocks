package com.simplify.restservices.controllers;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HolaMundoController {

    private ResourceBundleMessageSource messageSource;

    public HolaMundoController(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/hello-int")
    public String getMessagesInI18NFormat(@RequestHeader(name = "Accept-Language", required = false) String locale) {
        return messageSource.getMessage("label.hello", null,  new Locale(locale));
    }
}
