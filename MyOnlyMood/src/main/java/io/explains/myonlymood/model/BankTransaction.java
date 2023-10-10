package io.explains.myonlymood.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity @Builder @NoArgsConstructor @AllArgsConstructor
public class BankTransaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    private BankActiveCategory activeCategory;

    @NotNull
    private LocalDate transactionDate;

    @NotNull
    private BigDecimal thePrice;

}
