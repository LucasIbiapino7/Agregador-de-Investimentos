package com.devsuperior.agregadordeinvestimentos.dto;

public class AccountStockDTO {

    private String stockId;
    private Integer quantity;
    private Double total;

    public AccountStockDTO() {
    }

    public AccountStockDTO(String stockId, Integer quantity, Double total) {
        this.stockId = stockId;
        this.quantity = quantity;
        this.total = total;
    }

    public String getStockId() {
        return stockId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getTotal() {
        return total;
    }
}
