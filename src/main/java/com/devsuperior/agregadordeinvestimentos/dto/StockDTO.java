package com.devsuperior.agregadordeinvestimentos.dto;

import com.devsuperior.agregadordeinvestimentos.entities.Stock;

public class StockDTO {

    private String stockId;
    private String description;

    public StockDTO() {
    }

    public StockDTO(String stockId, String description) {
        this.stockId = stockId;
        this.description = description;
    }

    public StockDTO(Stock entity) {
        stockId = entity.getStockId();
        description = entity.getDescription();
    }

    public String getStockId() {
        return stockId;
    }

    public String getDescription() {
        return description;
    }
}
