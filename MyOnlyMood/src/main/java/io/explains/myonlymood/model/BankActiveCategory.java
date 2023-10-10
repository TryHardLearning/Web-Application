package io.explains.myonlymood.model;

import io.explains.myonlymood.model.enums.BanksActiveType;
import io.explains.myonlymood.model.enums.TransferStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankActiveCategory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter
    private Long id;

    private Integer priority;

    @NotNull
    private BanksActiveType Type;

    @NotNull
    private TransferStatus statusType;

}
