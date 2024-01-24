package com.devsuperior.agregadordeinvestimentos.dto;

import com.devsuperior.agregadordeinvestimentos.projections.UserAccountStocksProjection;

import java.util.*;

public class UserAccountStocksDTO {

    private String username;

    private Map<Long, AccountStockListDTO> accounts = new HashMap<>();

    public UserAccountStocksDTO() {
    }

    public UserAccountStocksDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<Long, AccountStockListDTO> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<Long, AccountStockListDTO> accounts) {
        this.accounts = accounts;
    }
}
