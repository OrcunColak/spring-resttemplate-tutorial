package com.colak.springresttemplatetutorial.service.resttemplate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class RestTemplateGetService {

    public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            // The result is of String type
            return restTemplate.getForEntity(url, responseType);
        } catch (RestClientException exception) {
            // Return a default ResponseEntity with the given value in case of error
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, T defaultValue) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            // The result is of String type
            return restTemplate.getForEntity(url, responseType);
        } catch (RestClientException exception) {
            // Return a default ResponseEntity with the given value in case of error
            return new ResponseEntity<>(defaultValue, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    public <T> T getForObject(String url, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        T result = null;
        try {
            result = restTemplate.getForObject(url, responseType);
        } catch (RestClientException exception) {
        }
        return result;
    }

    public <T> T getForObject(String url, Class<T> responseType, T defaultValue) {
        RestTemplate restTemplate = new RestTemplate();
        T result = null;
        try {
            result = restTemplate.getForObject(url, responseType);
        } catch (RestClientException exception) {
            result = defaultValue;
        }
        return result;
    }

    public <T> T getForObject(String url, Class<T> responseType, Map<String, ?> uriVariables) {
        RestTemplate restTemplate = new RestTemplate();
        T result = null;
        try {
            result = restTemplate.getForObject(url, responseType, uriVariables);
        } catch (RestClientException exception) {
        }
        return result;
    }

    public <T> T getForObject(String url, Class<T> responseType, Map<String, ?> uriVariables, T defaultValue) {
        RestTemplate restTemplate = new RestTemplate();
        T result = null;
        try {
            result = restTemplate.getForObject(url, responseType, uriVariables);
        } catch (RestClientException exception) {
            result = defaultValue;
        }
        return result;
    }

}
