package com.validation.service.impl;

import com.validation.exception.UrlNotFoundException;
import com.validation.model.UrlMapping;
import com.validation.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    private static final String BASE_URL = "http://short.ly/";

    public String shortenUrl(String longUrl) {
        // Check if the URL is already shortened
        UrlMapping existingMapping = urlRepository.findByLongUrl(longUrl);
        if (existingMapping != null) {
            return BASE_URL + existingMapping.getShortUrl();
        }

        // Generate a unique short URL
        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setLongUrl(longUrl);
        urlMapping.setShortUrl(BASE_URL);
        urlMapping = urlRepository.save(urlMapping);

        String shortUrl = encodeId(urlMapping.getId());
        urlMapping.setShortUrl(shortUrl);
        urlRepository.save(urlMapping);

        return BASE_URL + shortUrl;
    }

    public String expandUrl(String shortUrl) {
        UrlMapping urlMapping = urlRepository.findByShortUrl(shortUrl);
        if (urlMapping == null) {
            throw new UrlNotFoundException("URL not found!");
        }
        return urlMapping.getLongUrl();
    }

    private String encodeId(long id) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder shortUrl = new StringBuilder();
        while (id > 0) {
            shortUrl.append(characters.charAt((int) (id % characters.length())));
            id /= characters.length();
        }
        return shortUrl.reverse().toString();
    }
}
