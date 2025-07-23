package com.demo.urlshortner.config;

import java.time.LocalDateTime;

public class UrlResponse {
    private String shortLink;
    private LocalDateTime expiryTime;

    public UrlResponse(String shortLink, LocalDateTime expiryTime) {
        this.shortLink = shortLink;
        this.expiryTime = expiryTime;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }
}
