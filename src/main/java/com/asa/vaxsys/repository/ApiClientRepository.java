package com.asa.vaxsys.repository;


import com.asa.vaxsys.entity.ApiClient;
import com.asa.vaxsys.enums.ApiClientStatus;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Api client repository.
 */
public interface ApiClientRepository extends CrudRepository<ApiClient, Integer> {

    /**
     * Find first by order by id asc api client.
     *
     * @return the api client
     */
    ApiClient findFirstByOrderByIdAsc();

    /**
     * Find first by order by id desc api client.
     *
     * @return the api client
     */
    ApiClient findFirstByOrderByIdDesc();

    /**
     * Find by app key and app secret api client.
     *
     * @param appKey          the app key
     * @param appSecret       the app secret
     * @param apiClientStatus the api client status
     * @return the api client
     */
    ApiClient findFirstByAppKeyAndAppSecretAndStatus(String appKey, String appSecret, ApiClientStatus apiClientStatus);

    /**
     * Find first by app key api client.
     *
     * @param appKey the app key
     * @return the api client
     */
    ApiClient findFirstByAppKey(String appKey);
}

