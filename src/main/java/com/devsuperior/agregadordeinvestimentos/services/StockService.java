package com.devsuperior.agregadordeinvestimentos.services;

import com.devsuperior.agregadordeinvestimentos.client.BrapiClient;
import com.devsuperior.agregadordeinvestimentos.client.dto.BrapiResponseDTO;
import com.devsuperior.agregadordeinvestimentos.dto.AccountMinDTO;
import com.devsuperior.agregadordeinvestimentos.dto.AccountStockDTO;
import com.devsuperior.agregadordeinvestimentos.dto.StockDTO;
import com.devsuperior.agregadordeinvestimentos.entities.Account;
import com.devsuperior.agregadordeinvestimentos.entities.AccountStock;
import com.devsuperior.agregadordeinvestimentos.entities.Stock;
import com.devsuperior.agregadordeinvestimentos.repositories.AccountRepository;
import com.devsuperior.agregadordeinvestimentos.repositories.AccountStockRepository;
import com.devsuperior.agregadordeinvestimentos.repositories.StockRepository;
import com.devsuperior.agregadordeinvestimentos.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StockService {

    @Value("#{environment.TOKEN}")
    private String TOKEN;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountStockRepository accountStockRepository;

    @Autowired
    private BrapiClient brapiClient;

    @Transactional
    public StockDTO insert(StockDTO dto) {
        try {
            Stock stock = new Stock();
            //Validar se o stockId existe na Brapi
            BrapiResponseDTO response = brapiClient.getQuote(TOKEN, dto.getStockId());
            stock.setStockId(dto.getStockId());
            stock.setDescription(response.getResults().getFirst().getLongName());
            stock = stockRepository.save(stock);
            return new StockDTO(stock);
        }catch (Exception e){
            throw new ResourceNotFoundException("Recurso Não Encontrado na Brapi");
        }
    }

    @Transactional
    public AccountStockDTO insertStockAccount(Long id, AccountStockDTO dto){
        //LEMBRAR DE TRATAR AS EXCEÇÕES
        Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Conta Não Encontrada"));
        Stock stock = stockRepository.findById(dto.getStockId()).orElseThrow(() -> new ResourceNotFoundException("Stock Não encontrado"));
        AccountStock accountStock = new AccountStock(account, stock, dto.getQuantity());
        accountStock =  accountStockRepository.save(accountStock);
        return new AccountStockDTO(stock.getStockId(), dto.getQuantity(), 0.0);
    }

    @Transactional(readOnly = true)
    public List<StockDTO> getAll() {
        List<Stock> result = stockRepository.findAll();
        return result.stream().map(x -> new StockDTO(x)).toList();
    }
}
