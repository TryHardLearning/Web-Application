package com.explain.mindserver.dto;

import com.explain.mindserver.annotation.UniqueUsername;
import com.explain.mindserver.model.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class UserDTO {

    private Long id;

    @NotNull(message = "{com.explain.mindserver.model.User.NotNull.message}") @Size(min = 2, max = 32)
    @UniqueUsername
    private String username;
    @NotNull @Size(min = 2, max = 255)
    private String displayName;
    @NotNull @Size(min = 2, max = 512) @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;

}
