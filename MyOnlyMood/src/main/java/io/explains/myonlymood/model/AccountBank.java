package io.explains.myonlymood.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class AccountBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String bankName;

    @NotNull
    private String accountNumber;

    @ManyToMany
    private List<BankTransaction> transactions;

}
