package com.asa.vaxsys.exception;

import com.asa.vaxsys.enums.VaxsysServiceError;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * The type vaxsys service exception.
 */
@Getter
public class VaxsysServiceException extends RuntimeException {

    private Integer code;
    private String type;
    private HttpStatus httpStatus;

    /**
     * Instantiates a new vaxsys service exception.
     */
    public VaxsysServiceException() {
        super();
    }

    /**
     * Instantiates a new vaxsys service exception.
     *
     * @param message the message
     */
    public VaxsysServiceException(String message) {
        super(message);
    }

    /**
     * Instantiates a new vaxsys service exception.
     *
     * @param message   the message
     * @param exception the exception
     */
    public VaxsysServiceException(String message, Exception exception) {
        super(message, exception);
    }

    /**
     * Instantiates a new vaxsys service exception.
     *
     * @param vaxsysServiceError the vaxsys service error
     */
    public VaxsysServiceException(VaxsysServiceError vaxsysServiceError) {
        super();
        this.code = vaxsysServiceError.getCode();
        this.type = vaxsysServiceError.getType();
        this.httpStatus = HttpStatus.valueOf(vaxsysServiceError.getStatusCode());
    }

    /**
     * Instantiates a new vaxsys service exception.
     *
     * @param vaxsysServiceError the vaxsys service error
     * @param message            the message
     */
    public VaxsysServiceException(VaxsysServiceError vaxsysServiceError, String message) {
        super(message);
        this.code = vaxsysServiceError.getCode();
        this.type = vaxsysServiceError.getType();
        this.httpStatus = HttpStatus.valueOf(vaxsysServiceError.getStatusCode());
    }

    /**
     * Instantiates a new vaxsys service exception.
     *
     * @param vaxsysServiceError the vaxsys service error
     * @param message            the message
     * @param exception          the exception
     */
    public VaxsysServiceException(VaxsysServiceError vaxsysServiceError, String message, Exception exception) {
        super(message, exception);
        this.code = vaxsysServiceError.getCode();
        this.type = vaxsysServiceError.getType();
        this.httpStatus = HttpStatus.valueOf(vaxsysServiceError.getStatusCode());
    }
}

