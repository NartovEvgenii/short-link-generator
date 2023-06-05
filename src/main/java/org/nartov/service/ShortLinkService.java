package org.nartov.service;

import org.nartov.dto.ShortLinkDTO;
import org.nartov.dto.ShortLinkRequest;
import org.nartov.exeption.UserNotFoundException;

import java.util.List;

public interface ShortLinkService {
    ShortLinkDTO getShortLink(String shortLinkToken);

    List<ShortLinkDTO> getAllShortLink();
    ShortLinkDTO createShortLink(ShortLinkRequest shortLinkRequest) throws UserNotFoundException;
}
