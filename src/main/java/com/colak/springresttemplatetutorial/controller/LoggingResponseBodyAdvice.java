package com.colak.springresttemplatetutorial.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
@Slf4j
public class LoggingResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        // This method is called to determine if the advice should be applied
        // based on the return type and converter type.
        // Return true if you want to apply the advice, false otherwise.
        return true;
    }

    @Override
    public Object beforeBodyWrite(
            Object body,
            MethodParameter returnType,
            MediaType selectedContentType,
            Class selectedConverterType,
            ServerHttpRequest request,
            ServerHttpResponse response) {
        // This method is called just before the response body is written to the client.
        // You can modify the body or the response before it's sent to the client.

        log.info("""
                body : {}
                returnType : {}
                selectedContentType : {}
                selectedConverterType : {}
                """, body, returnType, selectedContentType, selectedConverterType);
        return body;
    }
}
