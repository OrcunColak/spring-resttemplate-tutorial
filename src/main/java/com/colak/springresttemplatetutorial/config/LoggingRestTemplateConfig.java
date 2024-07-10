package com.colak.springresttemplatetutorial.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Configuration
@Slf4j
public class LoggingRestTemplateConfig {

    @Bean
    public RestTemplate loggingRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        if (log.isDebugEnabled()) {
            ClientHttpRequestInterceptor interceptor = interceptor();

            // RestTemplate allows adding interceptors for logging or modifying requests and responses:
            restTemplate.getInterceptors().add(interceptor);
            // or we can do this
            // restTemplate.setInterceptors(List.of(interceptor));
        }

        // RestTemplate also provides mechanisms to handle errors more gracefully.
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                    log.info("Resource not found");
                }
            }
        });
        return restTemplate;
    }

    private ClientHttpRequestInterceptor interceptor() {
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
