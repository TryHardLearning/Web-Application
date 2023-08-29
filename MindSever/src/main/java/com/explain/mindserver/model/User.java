package com.explain.mindserver.model;

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
    @NotNull @Size(min = 2, max = 32)
    private String username;
    @NotNull @Size(min = 2, max = 255)
    private String displayName;
    @NotNull @Size(min = 2, max = 512) @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;
}
