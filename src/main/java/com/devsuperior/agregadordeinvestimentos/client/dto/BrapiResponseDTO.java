package com.devsuperior.agregadordeinvestimentos.client.dto;

import java.util.List;

public class BrapiResponseDTO {

    private List<StockBrapiDTO> results;

    public BrapiResponseDTO() {
    }

    public BrapiResponseDTO(List<StockBrapiDTO> results) {
        this.results = results;
    }

    public List<StockBrapiDTO> getResults() {
        return results;
    }
}
