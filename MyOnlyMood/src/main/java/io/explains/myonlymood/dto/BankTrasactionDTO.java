package io.explains.myonlymood.dto;

import io.explains.myonlymood.model.BankActiveCategory;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BankTrasactionDTO {
    @ManyToOne
    private BankActiveCategory activeCategory;

    @NotNull
    private LocalDate transactionDate;

    @NotNull
    private BigDecimal thePrice;
}
