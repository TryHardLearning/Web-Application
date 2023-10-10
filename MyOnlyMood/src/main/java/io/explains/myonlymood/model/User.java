package io.explains.myonlymood.model;

import io.explains.myonlymood.annotation.UniqueUsername;
import io.explains.myonlymood.model.NonEssential.Interest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity @Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String ocupation;

    @NotNull @UniqueUsername
    private String username;

    @NotNull @Getter @Setter
    private String password;

    @OneToOne
    private Actives actives;

}
