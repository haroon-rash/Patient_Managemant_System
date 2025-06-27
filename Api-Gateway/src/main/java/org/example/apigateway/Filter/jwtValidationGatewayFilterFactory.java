package org.example.apigateway.Filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class jwtValidationGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {

    private final WebClient webClient;

    public jwtValidationGatewayFilterFactory(WebClient.Builder webClient, @Value("${auth.service.uri}") String serviceUri) {
        this.webClient = webClient.baseUrl(serviceUri).build();
    }

    @Override
    public GatewayFilter apply(Object config) {


        return ((exchange, chain) ->
                String)
    }

}
