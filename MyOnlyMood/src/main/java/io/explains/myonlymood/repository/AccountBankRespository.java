package io.explains.myonlymood.repository;

import io.explains.myonlymood.model.AccountBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountBankRespository extends JpaRepository<AccountBank,Long> {}
