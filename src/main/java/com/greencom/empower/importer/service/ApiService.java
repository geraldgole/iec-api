package com.greencom.empower.importer.service;

import com.greencom.empower.importer.model.Device;
import com.greencom.empower.importer.model.Provider;
import com.greencom.empower.importer.model.ProviderType;
import com.greencom.empower.importer.model.exception.ApiException;
import com.greencom.empower.importer.model.exception.ClientApiException;
import com.greencom.empower.importer.model.exception.ServerApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.*;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ApiService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiService.class);

    @Value("${application.api.uri}")
    private String baseUri;

    @Autowired
    private RestTemplate restTemplate;


    public List<Provider> getProviders(ProviderType type, Map<String, String> filters) {

        String filterStr = filters.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining("&"));
        Provider[] providers = get(String.format("%s/providers?provider.type=%s&%s", baseUri, type.getType(), filterStr), Provider[].class);
        return Arrays.asList(providers);
    }

    public Provider getProvider(@NotNull String id) {
        return get(String.format("%s/providers/%s", baseUri, id), Provider.class);
    }

    public ResponseEntity<Provider> createProvider(Provider provider) {
        return post(String.format("%s/providers", baseUri), provider, Provider.class);
    }

    public void updateProvider(String id, Provider provider) {
        restTemplate.put(String.format("%s/providers/%s", baseUri, id), provider);
    }

    public List<Device> getDevices(Map<String, String> filters) {
        String filterStr = filters.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining("&"));
        Device[] devices = get(String.format("%s/devices?%s", baseUri, filterStr), Device[].class);
        return Arrays.asList(devices);
    }

    private <T> T get(String url, Class<T> responseType, Object... urlVariables) throws ApiException, RestClientException {

        try {
            ResponseEntity<T> response = restTemplate.getForEntity(url, responseType, urlVariables);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            throw new ClientApiException(String.format("Client error on GET %s : %s", url, e.getMessage()));
        } catch (HttpServerErrorException | ResourceAccessException e) {
            throw new ServerApiException(String.format("Server error on GET %s : %s", url, e.getMessage()));
        }
    }

    private <T> ResponseEntity<T> post(String url, Object object, Class<T> responseType, Object... urlVariables) throws ApiException, RestClientException {

        try {
            ResponseEntity<T> response = restTemplate.postForEntity(url, object, responseType, urlVariables);
            return response;
        } catch (HttpClientErrorException e) {
            throw new ClientApiException(String.format("Client error on POST %s : %s", url, e.getMessage()));
        } catch (HttpServerErrorException | ResourceAccessException e) {
            throw new ServerApiException(String.format("Server error on POST %s : %s", url, e.getMessage()));
        }
    }

    private void put(String url, Object object) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(object);
    }
}
