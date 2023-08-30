package com.explain.mindserver.model;

import com.explain.mindserver.annotation.UniqueUsername;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Entity
@Builder @AllArgsConstructor @NoArgsConstructor @Data
@Table(name = "UserAccount")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @NotNull(message = "{com.explain.mindserver.model.User.NotNull.message}") @Size(min = 2, max = 32)
    @UniqueUsername
    private String username;
    @NotNull @Size(min = 2, max = 255)
    private String displayName;
    @NotNull @Size(min = 2, max = 512) @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;
}
