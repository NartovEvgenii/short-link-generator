package org.nartov.service.impl;

import org.nartov.domain.LinkUser;
import org.nartov.repository.LinkUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private LinkUserRepository linkUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        LinkUser linkUser = linkUserRepository.findByEmail(email);
        if (linkUser == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new User(linkUser.getEmail(), linkUser.getPassword(), new ArrayList<>());
    }
}
