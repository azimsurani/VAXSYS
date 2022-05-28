package com.asa.vaxsys.service;

import com.asa.vaxsys.entity.ApiClient;
import com.asa.vaxsys.enums.ApiClientStatus;
import com.asa.vaxsys.exception.VaxsysServiceException;
import com.asa.vaxsys.repository.ApiClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The type Api client service.
 */
@Service
public class ApiClientService {

    private final ApiClientRepository apiClientRepository;

    /**
     * Instantiates a new Api client service.
     *
     * @param apiClientRepository the api client repository
     */
    public ApiClientService(ApiClientRepository apiClientRepository) {
        this.apiClientRepository = apiClientRepository;
    }

    /**
     * Find by app key and app secret api client.
     *
     * @param appKey          the app key
     * @param appSecret       the app secret
     * @param apiClientStatus the api client status
     * @return the api client
     */
    public ApiClient findByAppKeyAndAppSecret(String appKey, String appSecret, ApiClientStatus apiClientStatus) {
        ApiClient apiClient = apiClientRepository.findFirstByAppKeyAndAppSecretAndStatus(appKey, appSecret, apiClientStatus);
        return apiClient;
    }


    /**
     * Find first by app key api client.
     *
     * @param apiKey the api key
     * @return the api client
     */
    public ApiClient findFirstByAppKey(String apiKey) {
        ApiClient apiClient = apiClientRepository.findFirstByAppKey(apiKey);
        Optional.ofNullable(apiClient).orElseThrow(() -> new VaxsysServiceException("No Api Client found"));
        return apiClient;
    }
}
