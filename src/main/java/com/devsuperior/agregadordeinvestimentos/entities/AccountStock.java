package com.devsuperior.agregadordeinvestimentos.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_account_stock")
public class AccountStock {

    @EmbeddedId
    private AccountStockPK id = new AccountStockPK();

    private Integer quantity;

    public AccountStock() {
    }

    public AccountStock(Account account, Stock stock, Integer quantity) {
        id.setAccount(account);
        id.setStock(stock);
        this.quantity = quantity;
    }

    public Account getAccount(){
        return id.getAccount();
    }

    public void setAccount(Account account){
        id.setAccount(account);
    }

    public Stock getStock(){
        return id.getStock();
    }

    public void setAccount(Stock stock){
        id.setStock(stock);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
