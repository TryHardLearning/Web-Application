package io.explains.myonlymood.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Actives {

    @Id
    private Long id;

    @ManyToMany
    private List<AccountBank> banks;

    @ManyToMany
    private List<InvestmentBroker> investmentBrokers;

}
