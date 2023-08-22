package com.example.bookservice.tool;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class RestClient<T,V> {
    private String urlApi = "http://localhost:8081/api/";
    private RestTemplate template;
    private HttpHeaders httpHeaders;
    private HttpStatus httpStatus;

    public RestClient() {
        template = new RestTemplate();
        httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", "*/*");
        httpHeaders.add("content-type", "application/json");
    }

    public T get(String uri, Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<T> response = template.exchange(urlApi+uri, HttpMethod.GET, requestEntity, type);
        return response.getBody();
    }
}
