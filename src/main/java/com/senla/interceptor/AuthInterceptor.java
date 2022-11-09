package com.senla.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthInterceptor implements RequestInterceptor {

    @Value("${yandex.header}")
    private String header;

    @Value("${yandex.key}")
    private String key;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(header, key);
    }
}
