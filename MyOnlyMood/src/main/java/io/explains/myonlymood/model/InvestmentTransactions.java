package io.explains.myonlymood.model;

import io.explains.myonlymood.model.enums.InvestmentActiveType;
import io.explains.myonlymood.model.enums.StockBuyOrSell;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity @Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentTransactions {

    @Id
    private Long id;

    @NotNull
    private StockBuyOrSell buyOrSell;

    @NotNull
    private BigDecimal thePrice;

    private InvestmentActiveType type;

}
