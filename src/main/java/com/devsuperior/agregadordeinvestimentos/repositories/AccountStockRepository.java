package com.devsuperior.agregadordeinvestimentos.repositories;

import com.devsuperior.agregadordeinvestimentos.entities.Account;
import com.devsuperior.agregadordeinvestimentos.entities.AccountStock;
import com.devsuperior.agregadordeinvestimentos.entities.AccountStockPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountStockRepository extends JpaRepository<AccountStock, AccountStockPK> {
}
