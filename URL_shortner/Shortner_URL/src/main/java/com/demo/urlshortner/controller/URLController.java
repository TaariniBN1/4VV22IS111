package com.demo.urlshortner.controller;



import com.demo.urlshortner.service.URLService;
import com.demo.urlshortner.config.*;
import com.demo.urlshortner.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class URLController {

    @Autowired
    private URLService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<UrlResponse> shortenUrl(@RequestBody URLshoretRequest request) {
        try {
            UrlResponse response = urlService.shortenUrl(request);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/u/{code}")
    public RedirectView redirect(@PathVariable String code) {
        String originalUrl = urlService.getOriginalUrl(code);
        return new RedirectView(originalUrl);
    }
}

