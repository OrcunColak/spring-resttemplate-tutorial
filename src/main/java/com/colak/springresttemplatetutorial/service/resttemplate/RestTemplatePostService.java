package com.colak.springresttemplatetutorial.service.resttemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplatePostService {


    // Example that demonstrates how to post using postForEntity()
    public <T> ResponseEntity<T> postForEntity(String url, Object body, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        // The result is of String type
        return restTemplate.postForEntity(url, body, responseType);
    }

    // Example that demonstrates how to post using postForObject()
    public <T> T postForObject(String url, Object body, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> request = new HttpEntity<>(body);
        return restTemplate.postForObject(url, request, responseType);
    }

    // Example that demonstrates how to post using exchange()
    public <T> ResponseEntity<T> postWithExchange(String url, T body, Class<T> responseType) {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<T> requestEntity = new HttpEntity<>(body, header);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, responseType);
    }
}
