package org.nartov.controller;

import org.nartov.dto.ShortLinkDTO;
import org.nartov.dto.ShortLinkRequest;
import org.nartov.service.ShortLinkService;
import org.nartov.utils.ShortLinkTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "/shortLinks",
                produces = "application/json")
public class ShortLinkController {

    @Autowired
    private ShortLinkService shortLinkService;

    @GetMapping("/{shortLinkToken}")
    public ResponseEntity<Void> getShortLink(@PathVariable String shortLinkToken) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(shortLinkService.getShortLink(shortLinkToken).getFullUrl()))
                .build();
    }

    @PostMapping("/generate")
    public ShortLinkDTO generateShortLink(@RequestBody ShortLinkRequest shortLinkRequest) throws Exception {
        return shortLinkService.createShortLink(shortLinkRequest);
    }

}
