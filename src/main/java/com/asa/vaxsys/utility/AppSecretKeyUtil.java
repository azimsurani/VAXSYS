package com.asa.vaxsys.utility;

import com.asa.vaxsys.dto.AppSecretKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Base64;

/**
 * The type App secret key util.
 */
@Component
public class AppSecretKeyUtil {

    private static Logger logger = LoggerFactory.getLogger(AppSecretKeyUtil.class);


    /**
     * Gets app secret key.
     *
     * @param code the code
     * @return the app secret key
     */
    public AppSecretKey getAppSecretKey(String code) {
        String key = null;
        String secret = null;
        try {
            String[] fields = new String(Base64.getDecoder().decode(code)).split(":");
            if (fields.length > 1) {
                key = fields[0];
                secret = fields[1];
            }
        } catch (Exception exception) {
            logger.error("Decoding failed for " + code, exception);
        }
        return AppSecretKey.builder()
                .key(key)
                .secret(secret)
                .build();
    }
}

