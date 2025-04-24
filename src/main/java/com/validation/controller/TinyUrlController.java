package com.validation.controller;

import com.validation.service.impl.UrlService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
public class TinyUrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody String longUrl) {
        String shortUrl = urlService.shortenUrl(longUrl);
        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<String> expandUrl(@PathVariable String shortUrl) {
        String longUrl = urlService.expandUrl(shortUrl);
        return ResponseEntity.ok(longUrl);
    }
}
