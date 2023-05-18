package org.nartov.service;

import org.nartov.dto.ShortLinkDTO;
import org.nartov.dto.ShortLinkRequest;

public interface ShortLinkService {
    ShortLinkDTO getShortLink(String shortLinkToken);
    ShortLinkDTO createShortLink(ShortLinkRequest shortLinkRequest) throws Exception;
}
