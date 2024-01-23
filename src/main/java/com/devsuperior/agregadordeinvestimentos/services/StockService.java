package com.devsuperior.agregadordeinvestimentos.services;

import com.devsuperior.agregadordeinvestimentos.dto.AccountStockDTO;
import com.devsuperior.agregadordeinvestimentos.dto.StockDTO;
import com.devsuperior.agregadordeinvestimentos.entities.Account;
import com.devsuperior.agregadordeinvestimentos.entities.AccountStock;
import com.devsuperior.agregadordeinvestimentos.entities.Stock;
import com.devsuperior.agregadordeinvestimentos.repositories.AccountRepository;
import com.devsuperior.agregadordeinvestimentos.repositories.AccountStockRepository;
import com.devsuperior.agregadordeinvestimentos.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountStockRepository accountStockRepository;

    @Transactional
    public StockDTO insert(StockDTO dto) {
        Stock stock = new Stock();
        stock.setStockId(dto.getStockId());
        stock.setDescription(dto.getDescription());
        stock = stockRepository.save(stock);
        return new StockDTO(stock);
    }

    @Transactional
    public AccountStockDTO insertStockAccount(Long id, AccountStockDTO dto){
        //LEMBRAR DE TRATAR AS EXCEÇÕES
        Account account = accountRepository.getReferenceById(id);
        Stock stock = stockRepository.getReferenceById(dto.getStockId());

        AccountStock accountStock = new AccountStock(account, stock, dto.getQuantity());
        accountStock =  accountStockRepository.save(accountStock);

        return new AccountStockDTO(stock.getStockId(), dto.getQuantity(), 0.0);
    }
}
