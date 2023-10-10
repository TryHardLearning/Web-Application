package io.explains.myonlymood.dto;

import io.explains.myonlymood.annotation.UniqueUsername;
import jakarta.validation.constraints.NotNull;

public class UserDTO {

    @NotNull
    private String ocupation;

    @NotNull @UniqueUsername
    private String username;

    @NotNull
    private String password;
}
