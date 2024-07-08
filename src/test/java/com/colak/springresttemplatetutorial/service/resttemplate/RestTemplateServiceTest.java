package com.colak.springresttemplatetutorial.service.resttemplate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestTemplateServiceTest {

    @Autowired
    private RestTemplateService restTemplateService;

    @LocalServerPort
    int randomPort;

    @Test
    void getWithExchange() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/getquote";
        ResponseEntity<String> responseEntity = restTemplateService.getWithExchange(url, String.class);
        String page = responseEntity.getBody();
        assertThat(page).isEqualTo("quote");
    }

    @Test
    void getListWithExchange() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/getquotelist";
        ResponseEntity<List<String>> responseEntity = restTemplateService.getListWithExchange(url);
        List<String> result = responseEntity.getBody();
        List<String> expected = List.of("quote1", "quote1");
        Assertions.assertEquals(expected, result);
    }

}
