package com.colak.springresttemplatetutorial.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
@Slf4j
public class RestTemplateConfig {

    @Bean
    public RestTemplate loggingRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        if (log.isDebugEnabled()) {
            restTemplate.setInterceptors(List.of(interceptor()));
        }
        return restTemplate;
    }

    public static ClientHttpRequestInterceptor interceptor() {
        return (request, body, execution) -> {
            log.debug("SENDING REQUEST");
            log.debug("URI     ====> {}}", request.getURI());
            log.debug("METHOD  ====> {}}", request.getMethod());
            log.debug("BODY    ====> {}}", new String(body, StandardCharsets.UTF_8));
            log.debug("HEADERS ====> {}}", request.getHeaders());
            return execution.execute(request, body);
        };
    }
}
