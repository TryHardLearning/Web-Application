package io.explains.myonlymood.dto;

import io.explains.myonlymood.model.BankTransaction;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class AccountBankDTO {

    @NotNull
    private String name;

    @NotNull
    private String bankName;

    @NotNull
    private String accountNumber;

    @ManyToMany
    private List<BankTransaction> transactions;

}
