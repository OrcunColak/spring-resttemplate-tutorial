package com.colak.springresttemplatetutorial.controller;

import com.colak.springresttemplatetutorial.dto.QuoteRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quote")
public class QuoteController {

    // http://localhost:8080/api/v1/quote/get
    @GetMapping("/getquote")
    public String getQuote() {
        return "quote";
    }

    // http://localhost:8080/api/v1/quote/getquotelist
    @GetMapping("/getquotelist")
    public List<String> getQuoteList() {
        return List.of("quote1", "quote1");
    }

    // http://localhost:8080/api/v1/quote/newgetquote
    @GetMapping("/newgetquote")
    public String getNewQuote() {
        return "new quote";
    }

    @PostMapping(value = "/addquote", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addNewQuote(@RequestBody QuoteRequestDto quoteRequestDto) {
        return "Added new quote " + quoteRequestDto.quote();
    }

    // http://localhost:8080/api/v1/quote/redirect
    @GetMapping(value = "/redirect")
    public ResponseEntity<Void> redirect() {
        return ResponseEntity
                .status(HttpStatus.TEMPORARY_REDIRECT)
                .header("Location", "/api/v1/quote/newgetquote")
                .body(null);

    }

    @PatchMapping("/resource")
    public ResponseEntity<String> updateResource(@RequestBody String updatedData) {
        return ResponseEntity.ok("Resource updated successfully");
    }
}
