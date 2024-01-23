package com.devsuperior.agregadordeinvestimentos.services;

import com.devsuperior.agregadordeinvestimentos.dto.StockDTO;
import com.devsuperior.agregadordeinvestimentos.entities.Stock;
import com.devsuperior.agregadordeinvestimentos.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Transactional
    public StockDTO insert(StockDTO dto) {
        Stock stock = new Stock();
        stock.setStockId(dto.getStockId());
        stock.setDescription(dto.getDescription());
        stock = repository.save(stock);
        return new StockDTO(stock);
    }
}
