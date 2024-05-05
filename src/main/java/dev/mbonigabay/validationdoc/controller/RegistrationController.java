package dev.mbonigabay.validationdoc.controller;

import org.springframework.web.bind.annotation.RestController;

import dev.mbonigabay.validationdoc.model.request.RegistrationRequest;
import dev.mbonigabay.validationdoc.util.mapper.RegistrationMapper;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RegistrationController {
    @Autowired
    RegistrationMapper registrationMapper;

    Logger logger = LoggerFactory.getLogger(RegistrationController.class);
    @PostMapping("/registration")
    public void register(@Valid @RequestBody RegistrationRequest registrationRequest) {
        logger.info("Registered {}", registrationMapper.requestToEntity(registrationRequest));
    }
    
}
