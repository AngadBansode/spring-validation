package com.validation.repository;

import com.validation.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<UrlMapping, Long> {
    UrlMapping findByLongUrl(String longUrl);
    UrlMapping findByShortUrl(String shortUrl);
}
