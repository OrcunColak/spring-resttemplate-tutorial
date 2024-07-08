package com.colak.springresttemplatetutorial.service.resttemplate;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * PATCH does not work. See <a href="https://behumblefool.medium.com/spring-boot-resttemplate-patch-request-fix-8b44b16ff2c8">...</a>
 */
@Service
@RequiredArgsConstructor
public class RestTemplatePatchService {

    public <T> T patchForObject(String url, Object body, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> request = new HttpEntity<>(body);
        return restTemplate.patchForObject(url, request, responseType);
    }

    public <T> ResponseEntity<T> patchWithExchange(String url, T body, Class<T> responseType) {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<T> requestEntity = new HttpEntity<>(body, header);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url, HttpMethod.PATCH, requestEntity, responseType);
    }
}
