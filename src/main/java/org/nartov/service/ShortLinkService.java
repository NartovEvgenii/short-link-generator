package org.nartov.service;

import org.nartov.dto.ShortLinkDTO;
import org.nartov.dto.ShortLinkRequest;
import org.nartov.exeption.UserNotFoundException;

public interface ShortLinkService {
    ShortLinkDTO getShortLink(String shortLinkToken);
    ShortLinkDTO createShortLink(ShortLinkRequest shortLinkRequest) throws UserNotFoundException;
}
