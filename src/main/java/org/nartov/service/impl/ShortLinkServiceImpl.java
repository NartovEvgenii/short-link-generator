package org.nartov.service.impl;

import org.nartov.domain.ShortLink;
import org.nartov.dto.ShortLinkDTO;
import org.nartov.dto.ShortLinkRequest;
import org.nartov.exeption.UserNotFoundException;
import org.nartov.repository.LinkUserRepository;
import org.nartov.repository.ShortLinkRepository;
import org.nartov.service.ShortLinkService;
import org.nartov.utils.ShortLinkTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShortLinkServiceImpl implements ShortLinkService {
    @Autowired
    private ShortLinkRepository shortLinkRepository;

    @Autowired
    private LinkUserRepository linkUserRepository;

    @Autowired
    ShortLinkTokenUtils shortLinkTokenUtils;

    public ShortLinkDTO getShortLink(String shortLinkToken) {
        ShortLink shortLink = shortLinkRepository.findByShortLinkToken(shortLinkToken);
        return mapShortLinkToDTO(shortLink);
    }

    public List<ShortLinkDTO> getAllShortLink() {
        return shortLinkRepository.findAll()
                .stream()
                .map(this::mapShortLinkToDTO)
                .collect(Collectors.toList());
    }

    public ShortLinkDTO createShortLink(ShortLinkRequest shortLinkRequest) throws UserNotFoundException {
        ShortLink shortLink = new ShortLink();
        shortLink.setFullUrl(shortLinkRequest.getFullUrl());
        shortLink.setShortLinkToken(shortLinkTokenUtils.doGenerateLinkToken());
        shortLink.setLinkUser(linkUserRepository.findById(shortLinkRequest.getIdLinkUser())
                .orElseThrow(() ->
                        new UserNotFoundException(shortLinkRequest.getIdLinkUser())
                ));
        shortLink = shortLinkRepository.save(shortLink);
        return mapShortLinkToDTO(shortLink);
    }

    private ShortLinkDTO mapShortLinkToDTO(ShortLink shortLink){
        ShortLinkDTO shortLinkDTO = new ShortLinkDTO();
        shortLinkDTO.setIdShortLink(shortLink.getIdShortLink());
        shortLinkDTO.setShortLinkToken(shortLink.getShortLinkToken());
        shortLinkDTO.setFullUrl(shortLink.getFullUrl());
        shortLinkDTO.setIdLinkUser(shortLink.getLinkUser().getIdUser());
        return shortLinkDTO;
    }
}
