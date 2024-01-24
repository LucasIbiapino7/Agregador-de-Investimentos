package com.devsuperior.agregadordeinvestimentos.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountStockListDTO {

    private Long accountId;
    private String description;

    private List<AccountStockDTO> accountStock = new ArrayList<>();

    public AccountStockListDTO(Long accountId, String description) {
        this.accountId = accountId;
        this.description = description;
    }

    public AccountStockListDTO() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AccountStockDTO> getAccountStock() {
        return accountStock;
    }

    public Double getTotal(){
        Double sum = 0.0;
        for (AccountStockDTO dto : accountStock){
            sum += dto.getTotal();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountStockListDTO that = (AccountStockListDTO) o;

        return Objects.equals(accountId, that.accountId);
    }

    @Override
    public int hashCode() {
        return accountId != null ? accountId.hashCode() : 0;
    }
}
