package io.explains.myonlymood.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder @AllArgsConstructor
public class GenericResponse {
    @Getter
    private String message;
}
