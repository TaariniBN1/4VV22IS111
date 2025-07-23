package com.demo.urlshortner.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
public class URL {
    @Id
    private String shortCode;
    @Column(nullable = false)
    private String originalUrl;
    @Column(nullable = false)
    private LocalDateTime expiryTime;
	public String getShortCode() {
		return shortCode;
	}
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public LocalDateTime getExpiryTime() {
		return expiryTime;
	}
	public void setExpiryTime(LocalDateTime expiryTime) {
		this.expiryTime = expiryTime;
	}
	public URL() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "URL [shortCode=" + shortCode + ", originalUrl=" + originalUrl + ", expiryTime=" + expiryTime + "]";
	}
    

}

