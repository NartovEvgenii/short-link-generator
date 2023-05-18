package org.nartov.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.nartov.domain.LinkUser;

@Data
@NoArgsConstructor
public class ShortLinkDTO {
    private Long idShortLink;

    private String shortLinkToken;

    private String fullUrl;

    private Long idLinkUser;
}
