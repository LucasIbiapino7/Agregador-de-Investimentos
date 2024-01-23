package com.devsuperior.agregadordeinvestimentos.client.dto;

public class StockBrapiDTO {

    private Double regularMarketPrice;

    public StockBrapiDTO() {
    }

    public StockBrapiDTO(Double regularMarketPrice) {
        this.regularMarketPrice = regularMarketPrice;
    }

    public Double getRegularMarketPrice() {
        return regularMarketPrice;
    }
}
