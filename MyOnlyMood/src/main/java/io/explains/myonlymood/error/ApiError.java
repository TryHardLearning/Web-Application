package io.explains.myonlymood.error;

import java.util.Map;

public class ApiError {

    private int status;
    private String message;
    private String url;
    Map<String, Object> validationErrors;

    public ApiError(int status, String message, String url, Map<String, Object> validationErrors) {
        this.status = status;
        this.message = message;
        this.url = url;
        this.validationErrors = validationErrors;
    }

    public ApiError(String message, String url,int status) {
        this.status = status;
        this.message = message;
        this.url = url;
    }

}
