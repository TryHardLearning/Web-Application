package io.explains.myonlymood.model.NonEssential;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Builder
@AllArgsConstructor
@NoArgsConstructor
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long Id;

    @NotNull
    private String interest;

    @ManyToOne
    @JoinColumn(name = "steps_id")
    @NotNull
    private Steps steps;

}
