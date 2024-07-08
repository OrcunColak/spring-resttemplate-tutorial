package com.colak.springresttemplatetutorial.service.resttemplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestTemplateGetServiceTest {

    @Autowired
    private RestTemplateGetService restTemplateGetService;

    @LocalServerPort
    int randomPort;

    @Test
    void getForEntity() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/getquote";
        ResponseEntity<String> page = restTemplateGetService.getForEntity(url, String.class);
        assertThat(page.getBody()).isEqualTo("quote");
    }

    @Test
    void getForObject() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/getquote";
        String page = restTemplateGetService.getForObject(url, String.class);
        assertThat(page).isEqualTo("quote");
    }

    @Test
    void getForObject1() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/getquote1/{quote}";
        Map<String, String> map = new HashMap<>();
        map.put("quote", "alo");

        String page = restTemplateGetService.getForObject(url, String.class, map);
        assertThat(page).isEqualTo("alo");
    }

}
