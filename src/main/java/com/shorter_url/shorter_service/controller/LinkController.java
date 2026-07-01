package com.shorter_url.shorter_service.controller;

import com.shorter_url.shorter_service.DTO.*;
import com.shorter_url.shorter_service.service.LinkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class LinkController {

    private final LinkService linkService;

    @PostMapping("/api/links")
    public ResponseEntity<ShortLinkResponse> getShortUrl(@Valid @RequestBody CreateLinkRequest request){

        ShortLinkResponse response = linkService.createLink(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode){

        OriginalLinkResponse response = linkService.getOriginalLink(shortCode);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(response.originalLink()))
                .build();
    }

    @GetMapping("/api/links/{shortCode}")
    public ResponseEntity<LinkInformationResponse> information(@PathVariable String shortCode){

        LinkInformationResponse response = linkService.getInformation(shortCode);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @DeleteMapping("/api/links/{shortCode}")
    public ResponseEntity<Void> delete(@PathVariable String shortCode){

        linkService.delete(shortCode);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @GetMapping("/api/links/{shortCode}/stats")
    public ResponseEntity<StatisticsResponse> stats(@PathVariable String shortCode){

        StatisticsResponse response = linkService.getStats(shortCode);

        return ResponseEntity.
                status(HttpStatus.OK)
                .body(response);
    }

}
