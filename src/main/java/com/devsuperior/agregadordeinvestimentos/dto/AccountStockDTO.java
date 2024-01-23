package com.devsuperior.agregadordeinvestimentos.dto;

public class AccountStockDTO {

    private String stockId;
    private Integer quantity;

    public AccountStockDTO() {
    }

    public AccountStockDTO(String stockId, Integer quantity) {
        this.stockId = stockId;
        this.quantity = quantity;
    }

    public String getStockId() {
        return stockId;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
