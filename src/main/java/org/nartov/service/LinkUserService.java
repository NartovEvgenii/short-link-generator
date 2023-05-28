package org.nartov.service;

import org.nartov.dto.LinkUserDTO;
import org.nartov.dto.LinkUserDTORequest;
import org.nartov.dto.LinkUserRequest;
import org.springframework.security.authentication.BadCredentialsException;

public interface LinkUserService {

    LinkUserDTO login(LinkUserRequest userRequest) throws BadCredentialsException;

    LinkUserDTO register(LinkUserDTORequest userDTORequest);
}
