package io.explains.myonlymood.dto;

import io.explains.myonlymood.model.enums.InvestmentActiveType;
import io.explains.myonlymood.model.enums.StockBuyOrSell;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class InvestmentTrasactionsDTO {

    @NotNull
    private StockBuyOrSell buyOrSell;

    @NotNull
    private BigDecimal thePrice;

    @NotNull
    private InvestmentActiveType type;
}
