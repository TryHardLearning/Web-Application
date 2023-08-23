package com.explain.mindserver.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String username;
    @NotNull
    private String displayName;
    @NotNull
    private String password;
}
