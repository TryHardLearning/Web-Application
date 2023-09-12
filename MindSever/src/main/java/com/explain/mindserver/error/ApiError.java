package com.explain.mindserver.error;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
public class ApiError {
    private long timestamp = new Date().getTime();
    private int status;
    private String message;
    private String url;

    private Map<String, String> validationErrors;

    public ApiError(int status, String message, String url,Map<String, String> validationErrors){
        this.message = message;
        this.status = status;
        this.url = url;
        this.validationErrors = validationErrors;
    }
    public ApiError(String message, String url,int status) {
        this.status = status;
        this.message = message;
        this.url = url;
    }
}
