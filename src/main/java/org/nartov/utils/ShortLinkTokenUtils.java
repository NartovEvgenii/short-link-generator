package org.nartov.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.util.UUID;

@Component
public class ShortLinkTokenUtils {

    @Value("${linkSecret}")
    private String linkSecret;

    public String doGenerateLinkToken() {
        return UUID.nameUUIDFromBytes((linkSecret + System.currentTimeMillis()).getBytes()).toString()
                .replace("-","");
    }
}
