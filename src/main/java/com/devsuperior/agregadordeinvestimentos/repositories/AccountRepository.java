package com.devsuperior.agregadordeinvestimentos.repositories;

import com.devsuperior.agregadordeinvestimentos.entities.Account;
import com.devsuperior.agregadordeinvestimentos.entities.User;
import com.devsuperior.agregadordeinvestimentos.projections.UserAccountStocksProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(nativeQuery = true, value = "SELECT  tb_user.username, tb_account.description, tb_stock.stock_id AS stockId, tb_stock.description AS descriptionStock, quantity, tb_account.id AS accountId " +
            "FROM tb_account " +
            "INNER JOIN tb_user ON tb_user.id = tb_account.user_id " +
            "LEFT JOIN tb_account_stock ON tb_account.id = tb_account_stock.account_id " +
            "LEFT JOIN tb_stock ON tb_stock.stock_id = tb_account_stock.stock_id " +
            "WHERE tb_user.id = :id")
    List<UserAccountStocksProjection> getUserAccountStock(Long id);
}
