package com.colak.springresttemplatetutorial.controller;

import com.colak.springresttemplatetutorial.service.resttemplate.RestTemplateGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// See https://readmedium.com/spring-boot-integrates-ip2region-to-implement-ip-whitelist-7e4c18bb6f4d
@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class IpRegionController {

    private final RestTemplateGetService restTemplateGetService;

    public record CountryInfo(String query,
                              String status,
                              String country,
                              String countryCode,
                              String region,
                              String regionName,
                              String city,
                              String zip,
                              String lat,
                              String lon,
                              String timezone,
                              String isp,
                              String org,
                              String as) {
    }

    // http://localhost:8080/api/v1/address/get?ip=52.220.113.16
    @GetMapping("/get")
    public CountryInfo getQuote1(@RequestParam String ip) {
        String url = "http://ip-api.com/json/" + ip;
        return restTemplateGetService.getForObject(url, CountryInfo.class);
    }
}
