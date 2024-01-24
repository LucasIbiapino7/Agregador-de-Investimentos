package com.devsuperior.agregadordeinvestimentos.repositories;

import com.devsuperior.agregadordeinvestimentos.entities.Account;
import com.devsuperior.agregadordeinvestimentos.entities.AccountStock;
import com.devsuperior.agregadordeinvestimentos.entities.AccountStockPK;
import com.devsuperior.agregadordeinvestimentos.projections.UserAccountStocksProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountStockRepository extends JpaRepository<AccountStock, AccountStockPK> {


}
