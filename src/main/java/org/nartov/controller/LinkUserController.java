package org.nartov.controller;

import org.nartov.dto.LinkUserDTO;
import org.nartov.dto.LinkUserDTORequest;
import org.nartov.dto.LinkUserRequest;
import org.nartov.service.LinkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user",
        produces = "application/json")
public class LinkUserController {

    @Autowired
    private LinkUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LinkUserDTO login(@RequestBody LinkUserRequest userRequest) throws Exception {
        return userService.login(userRequest);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public LinkUserDTO register(@RequestBody LinkUserDTORequest userDTORequest) throws Exception {
        return userService.register(userDTORequest);
    }
}
