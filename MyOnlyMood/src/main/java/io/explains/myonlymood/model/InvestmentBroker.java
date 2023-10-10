package io.explains.myonlymood.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentBroker {

    @Id
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String code;

    @ManyToMany
    private List<InvestmentTransactions> transactions;
}
