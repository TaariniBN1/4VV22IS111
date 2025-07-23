package com.demo.urlshortner.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.demo.urlshortner.config.Logging;

public class ServiceLog {
	private final String LOG_URL = "https://20.244.56.144/evaluation-service/logs";
    private final RestTemplate restTemplate = new RestTemplate();

    public void sendLog(String level, String packageName, String message) {
        Logging log = new Logging("SpringBoot Stack", level, packageName, message);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Logging> entity = new HttpEntity<>(log, headers);

        try {
            restTemplate.postForEntity(LOG_URL, entity, String.class);
        } catch (Exception e) {
            System.err.println("Failed to log: " + e.getMessage());
        }
    }
}
