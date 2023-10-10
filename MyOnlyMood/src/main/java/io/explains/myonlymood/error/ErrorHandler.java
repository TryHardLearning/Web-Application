package io.explains.myonlymood.error;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public class ErrorHandler implements ErrorController {

    private final ErrorAttributes error;

    public ErrorHandler(ErrorAttributes error) {
        this.error = error;
    }

    @GetMapping
    public ApiError handleError(WebRequest webRequest){
        Map<String, Object> attributes = error.getErrorAttributes(
                webRequest,
                ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE)
        );
        return  new ApiError(
                (String) attributes.get("message"),
                (String) attributes.get("path"),
                (Integer) attributes.get("status")
        );
    }
}
