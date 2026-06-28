package com.shorter_url.shorter_service.service;

import com.shorter_url.shorter_service.DTO.OriginalLinkRequest;
import com.shorter_url.shorter_service.DTO.ShortLinkResponse;
import com.shorter_url.shorter_service.Entity.Link;
import com.shorter_url.shorter_service.repository.LinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class LinkService {

    private final LinkRepository repository;

    public ShortLinkResponse createLink(OriginalLinkRequest request){

        final String LINK = "abc";
        Random random = new Random();
        int number = random.nextInt(100);
        String shortCode = LINK + number;

        Link link = new Link();
        link.setLongUrl(request.originalUrl());
        link.setShortCode(shortCode);
        link.setCreatedAt(LocalDateTime.now());
        link.setClick(0L);
        Link savedLink = repository.save(link);

        ShortLinkResponse shortLinkResponse = new ShortLinkResponse(shortCode);

        return shortLinkResponse;
    }
}
