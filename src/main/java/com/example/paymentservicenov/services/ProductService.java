package com.example.paymentservicenov.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    private final RestTemplate _restTemplate;

    public ProductService(RestTemplate restTemplate) {
        _restTemplate = restTemplate;
    }
    public String getProductDetails(String productId) {
        return _restTemplate.getForObject("http://PRODUCTSERVICE/Products/" + productId, String.class);
    }
}
