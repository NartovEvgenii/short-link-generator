package org.nartov.service.impl;

import org.nartov.domain.LinkUser;
import org.nartov.dto.LinkUserDTO;
import org.nartov.dto.LinkUserDTORequest;
import org.nartov.dto.LinkUserRequest;
import org.nartov.repository.LinkUserRepository;
import org.nartov.service.LinkUserService;
import org.nartov.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LinkUserServiceImpl implements LinkUserService {
    @Autowired
    private LinkUserRepository linkUserRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    public LinkUserDTO login(LinkUserRequest userRequest) throws BadCredentialsException {
        LinkUser linkUser = linkUserRepository.findByEmail(userRequest.getEmail());
        String token = checkAuthentication(linkUser.getEmail(), userRequest.getPassword());
        return mapLinkUserToLinkUserDTO(linkUser, token);
    }


    public LinkUserDTO register(LinkUserDTORequest userDTORequest) {
        LinkUser linkUser = mapLinkUserDTORequestToLinkUserDTO(userDTORequest);
        linkUser = linkUserRepository.save(linkUser);
        String token = createAuthenticationToken(linkUser.getEmail(), linkUser.getPassword());
        return mapLinkUserToLinkUserDTO(linkUser, token);
    }

    private String checkAuthentication(String email, String password) throws BadCredentialsException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException | BadCredentialsException e) {
            throw new BadCredentialsException("There is no user with this password or login.");
        }
        return createAuthenticationToken(email, password);
    }

    private String createAuthenticationToken(String email, String password){
        return jwtTokenUtil.generateToken(new User(email, password, new ArrayList<>()));
    }

    private LinkUserDTO mapLinkUserToLinkUserDTO(LinkUser linkUser, String token){
        LinkUserDTO linkUserDTO  = new LinkUserDTO();
        linkUserDTO.setIdUser(linkUser.getIdUser());
        linkUserDTO.setEmail(linkUser.getEmail());
        linkUserDTO.setName(linkUser.getName());
        linkUserDTO.setSurname(linkUser.getSurname());
        linkUserDTO.setToken(token);
        return linkUserDTO;
    }

    private LinkUser mapLinkUserDTORequestToLinkUserDTO(LinkUserDTORequest linkUserDTORequest){
        LinkUser linkUser  = new LinkUser();
        linkUser.setEmail(linkUserDTORequest.getEmail());
        linkUser.setName(linkUserDTORequest.getName());
        linkUser.setSurname(linkUserDTORequest.getSurname());
        linkUser.setPassword(bcryptEncoder.encode(linkUserDTORequest.getPassword()));
        return linkUser;
    }
}
