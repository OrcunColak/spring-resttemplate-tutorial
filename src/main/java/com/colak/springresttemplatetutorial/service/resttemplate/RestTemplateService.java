package com.colak.springresttemplatetutorial.service.resttemplate;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestTemplateService {

    public <T> ResponseEntity<T> getWithExchange(String url, Class<T> responseType) {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(header);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url, HttpMethod.GET, requestEntity, responseType);
    }

    public <T> T getForObject(String url, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, responseType);
    }

    /**
     * Example that demonstrates how to get a list using exchange()
     */
    public <T> ResponseEntity<List<T>> getListWithExchange(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
    }

    /**
     * Example that demonstrates how to post using postForEntity()
     */
    public <T> ResponseEntity<T> postForEntity(String url, Object object, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        // The result is of String type
        return restTemplate.postForEntity(url, object, responseType);
    }

    /**
     * Example that demonstrates how to post using postForObject()
     */
    public <T> T postForObject(String url, Object object, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> request = new HttpEntity<>(object);
        // The result is of String type
        return restTemplate.postForObject(url, request, responseType);
    }

    public <T> ResponseEntity<T> postWithExchange(String url, T object, Class<T> responseType) {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<T> requestEntity = new HttpEntity<>(object, header);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, responseType);

    }
}
