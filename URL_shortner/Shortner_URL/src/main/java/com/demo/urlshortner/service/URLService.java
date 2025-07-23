package com.demo.urlshortner.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.urlshortner.dao.URLRepository;
import com.demo.urlshortner.entity.URL;

import java.time.LocalDateTime;
import java.util.UUID;
public class URLService {
	@Autowired
    private URLRepository urlRepo;

    @Autowired
    private ServiceLog logService;

    public String shortenUrl(String originalUrl, String customCode) {
        String code = (customCode != null && !customCode.isEmpty()) ? customCode : generateShortCode();

        if (urlRepo.existsById(code)) {
            throw new RuntimeException("Custom short code already exists: " + code);
        }

        URL  mapping = new URL();
        mapping.setShortCode(code);
        mapping.setOriginalUrl(originalUrl);
        mapping.setExpiryTime(LocalDateTime.now().plusMinutes(30));

        urlRepo.save(mapping);
        logService.sendLog("INFO", "UrlShortenerService", "Shortened URL created: " + code);

        return "http://localhost:8080/u/" + code;
    }

    public String getOriginalUrl(String shortCode) {
        URL mapping = urlRepo.findById(shortCode)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));

        if (mapping.getExpiryTime().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Short URL expired");
        }

        logService.sendLog("INFO", "UrlShortenerService", "Redirecting to original URL for: " + shortCode);
        return mapping.getOriginalUrl();
    }

    private String generateShortCode() {
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        while (urlRepo.existsById(uuid)) {
            uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        }
        return uuid;
    }

}
