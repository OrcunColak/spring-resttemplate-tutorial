package com.colak.springresttemplatetutorial.service.resttemplate;

import com.colak.springresttemplatetutorial.dto.QuoteRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestTemplatePostServiceTest {

    @Autowired
    private RestTemplatePostService restTemplateService;

    @LocalServerPort
    int randomPort;

    @Test
    void postForEntity() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/addquote";
        QuoteRequestDto quoteRequestDto = new QuoteRequestDto("new quote");
        ResponseEntity<String> responseEntity = restTemplateService.postForEntity(url, quoteRequestDto, String.class);

        String result = responseEntity.getBody();
        String expected = "Added new quote " + quoteRequestDto.quote();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void postForObject() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/addquote";
        QuoteRequestDto quoteRequestDto = new QuoteRequestDto("new quote");
        String result = restTemplateService.postForObject(url, quoteRequestDto, String.class);

        String expected = "Added new quote " + quoteRequestDto.quote();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void postWithExchange() throws JsonProcessingException {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/addquote";
        QuoteRequestDto quoteRequestDto = new QuoteRequestDto("new quote");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(quoteRequestDto);

        ResponseEntity<String> responseEntity = restTemplateService.postWithExchange(url, json, String.class);
        String result = responseEntity.getBody();
        String expected = "Added new quote " + quoteRequestDto.quote();
        Assertions.assertEquals(expected, result);
    }
}
