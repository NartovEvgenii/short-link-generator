package org.nartov.service;

import org.nartov.dto.LinkUserDTO;
import org.nartov.dto.LinkUserDTORequest;
import org.nartov.dto.LinkUserRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface LinkUserService {

    LinkUserDTO login(LinkUserRequest userRequest) throws Exception;

    LinkUserDTO register(LinkUserDTORequest userDTORequest);
}
