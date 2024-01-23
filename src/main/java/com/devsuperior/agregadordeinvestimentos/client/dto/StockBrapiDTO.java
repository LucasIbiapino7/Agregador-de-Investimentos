package com.devsuperior.agregadordeinvestimentos.client.dto;

public class StockBrapiDTO {

    private Double regularMarketPrice;
    private String longName;

    public StockBrapiDTO() {
    }

    public StockBrapiDTO(Double regularMarketPrice, String longName) {
        this.regularMarketPrice = regularMarketPrice;
        this.longName = longName;
    }

    public Double getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public String getLongName() {
        return longName;
    }
}
