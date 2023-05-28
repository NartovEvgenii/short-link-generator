package org.nartov.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.util.UUID;

@Component
public class ShortLinkTokenUtils {

    @Value("${linkSecret}")
    private String linkSecret;
    @Autowired
    UniqueNumberGenerator uniqueNumberGenerator;

    public String doGenerateLinkToken() {
        return UUID.nameUUIDFromBytes((linkSecret + uniqueNumberGenerator.nextNumber() + System.currentTimeMillis()).getBytes()).toString()
                .replace("-","");
    }
}
