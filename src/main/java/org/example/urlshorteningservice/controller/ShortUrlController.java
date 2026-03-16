package org.example.urlshorteningservice.controller;

import org.example.urlshorteningservice.dto.UrlRequest;
import org.example.urlshorteningservice.model.UrlMapping;
import org.example.urlshorteningservice.service.UrlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class ShortUrlController {

    private final UrlService service;

    public ShortUrlController(UrlService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public ResponseEntity<UrlMapping> create(@RequestBody UrlRequest request){

        UrlMapping mapping = service.createShortUrl(request.getUrl());

        return ResponseEntity.status(201).body(mapping);
    }

    @GetMapping("{code}")
    public ResponseEntity<UrlMapping> get(@PathVariable String code){

        UrlMapping mapping = service.getUrl(code);

        return ResponseEntity.status(302)
                .location(URI.create(mapping.getUrl()))
                .build();
    }

    @PutMapping("/shorten/{code}")
    public ResponseEntity<UrlMapping> update(
            @PathVariable String code,
            @RequestBody UrlRequest request){

        return ResponseEntity.ok(service.updateUrl(code, request.getUrl()));
    }

    @DeleteMapping("/shorten/{code}")
    public ResponseEntity<Void> delete(@PathVariable String code){

        service.delete(code);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/shorten/{code}/stats")
    public ResponseEntity<UrlMapping> stats(@PathVariable String code){

        return ResponseEntity.ok(service.getStats(code));
    }
}
