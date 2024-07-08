package com.colak.springresttemplatetutorial.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@Slf4j
public class TimeoutRestTemplateConfig {

    @Bean
    public RestTemplate timeoutRestTemplate() {
        var timeout = 5_000;

        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory  = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        clientHttpRequestFactory.setConnectionRequestTimeout(timeout);

        return new RestTemplate(clientHttpRequestFactory);
    }

}
