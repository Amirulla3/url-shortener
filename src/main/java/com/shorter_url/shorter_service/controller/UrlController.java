package com.shorter_url.shorter_service.controller;

import com.shorter_url.shorter_service.DTO.OriginalLinkRequest;
import com.shorter_url.shorter_service.DTO.ShortLinkResponse;
import com.shorter_url.shorter_service.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final LinkService linkService;

    @PostMapping("/api/links")
    public ShortLinkResponse getShortUrl(@RequestBody OriginalLinkRequest originalLinkRequest){

        return linkService.createLink(originalLinkRequest);

    }
}
