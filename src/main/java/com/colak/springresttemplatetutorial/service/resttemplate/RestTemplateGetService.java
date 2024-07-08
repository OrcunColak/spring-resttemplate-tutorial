package com.colak.springresttemplatetutorial.service.resttemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class RestTemplateGetService {

    // Example that demonstrates how to post using getForEntity()
    public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        // The result is of String type
        return restTemplate.getForEntity(url, responseType);
    }

    public <T> T getForObject(String url, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, responseType);
    }

    public <T> T getForObject(String url, Class<T> responseType, Map<String, ?> uriVariables) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, responseType, uriVariables);
    }

}
