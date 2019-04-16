package com.greencom.empower.importer.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.util.Arrays;

@Configuration
public class RestTemplateConfig {

    @Value("${application.api.key}")
    private String apiKey;

    @Value("#{systemEnvironment['https_proxy']}")
    private String httpsProxy;


    @Bean
    public RestTemplate restTemplate() {

        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        if (StringUtils.isNotEmpty(this.httpsProxy)) {
            URI proxyUri = URI.create(this.httpsProxy.contains("://") ? this.httpsProxy : ("http://" + this.httpsProxy));
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyUri.getHost(), proxyUri.getPort()));
            requestFactory.setProxy(proxy);
        }

        RestTemplate restTemplate = new RestTemplate(requestFactory);
        restTemplate.setInterceptors(Arrays.asList((r, b, e) -> {
            r.getHeaders().set("GCN-APIKEY", this.apiKey);
            return e.execute(r, b);
        }));
        return restTemplate;
    }
}
