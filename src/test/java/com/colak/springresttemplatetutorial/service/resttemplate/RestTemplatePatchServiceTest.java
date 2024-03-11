package com.colak.springresttemplatetutorial.service.resttemplate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestTemplatePatchServiceTest {
    @Autowired
    private RestTemplatePatchService restTemplatePatchService;

    @LocalServerPort
    int randomPort;

    @Test
    void testPatchWithExchange() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/resource";

        String result = restTemplatePatchService.patchForObject(url, "test", String.class);
        String expected = "Resource updated successfully";
        Assertions.assertEquals(expected, result);
    }
}
