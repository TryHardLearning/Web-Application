package com.explain.mindserver.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Builder @AllArgsConstructor @NoArgsConstructor
@Table(name = "UserAccount")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    private String username;

    private String displayName;

    private String password;
}
