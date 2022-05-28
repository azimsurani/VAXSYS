package com.asa.vaxsys.interceptor;

import com.asa.vaxsys.dto.AppSecretKey;
import com.asa.vaxsys.enums.ApiClientStatus;
import com.asa.vaxsys.service.ApiClientService;
import com.asa.vaxsys.utility.AppSecretKeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * The type Auth interceptor.
 */
@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {


    private final AppSecretKeyUtil appSecretKeyUtil;

    private final ApiClientService apiClientService;

    /**
     * Instantiates a new Auth interceptor.
     *
     * @param appSecretKeyUtil the app secret key util
     * @param apiClientService the api client service
     */
    @Autowired
    public AuthInterceptor(AppSecretKeyUtil appSecretKeyUtil, ApiClientService apiClientService) {
        this.appSecretKeyUtil = appSecretKeyUtil;
        this.apiClientService = apiClientService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String taxAppToken = getTweakAppToken(request);
        if (!StringUtils.isEmpty(taxAppToken)) {
            return authenticateAppToken(taxAppToken, response);
        }
        log.info("401 Missing authentication keys");
        response.setStatus(401);
        return false;
    }

    private boolean authenticateAppToken(String taxAppToken, HttpServletResponse response) {
        AppSecretKey appKeySecret = appSecretKeyUtil.getAppSecretKey(taxAppToken);
        if (StringUtils.isEmpty(appKeySecret.getKey()) || StringUtils.isEmpty(appKeySecret.getSecret())) {
            response.setStatus(401);
            log.info("401 Missing authentication keys");
            return false;
        }

        try {
            apiClientService.findByAppKeyAndAppSecret(appKeySecret.getKey(), appKeySecret.getSecret(), ApiClientStatus.Active);
            log.info("APP_TOKEN:: {} is valid", taxAppToken);
            return true;
        } catch (Exception e) {
            log.error("401 Authentication failed");
        }

        log.info("401 Unauthorized for APP_TOKEN: " + taxAppToken);
        response.setStatus(401);
        return false;
    }

    private String getTweakAppToken(HttpServletRequest request) {
        return request.getHeader("APP_TOKEN");
    }
}

