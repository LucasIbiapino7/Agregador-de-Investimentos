package com.devsuperior.agregadordeinvestimentos.services;

import com.devsuperior.agregadordeinvestimentos.client.BrapiClient;
import com.devsuperior.agregadordeinvestimentos.client.dto.BrapiResponseDTO;
import com.devsuperior.agregadordeinvestimentos.dto.AccountDTO;
import com.devsuperior.agregadordeinvestimentos.dto.AccountStockDTO;
import com.devsuperior.agregadordeinvestimentos.entities.Account;
import com.devsuperior.agregadordeinvestimentos.entities.AccountStock;
import com.devsuperior.agregadordeinvestimentos.entities.Stock;
import com.devsuperior.agregadordeinvestimentos.entities.User;
import com.devsuperior.agregadordeinvestimentos.repositories.AccountRepository;
import com.devsuperior.agregadordeinvestimentos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Value("#{environment.TOKEN}")
    private String TOKEN;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BrapiClient brapiClient;

    @Transactional(readOnly = true)
    public List<AccountStockDTO> getStocksByAccount(Long id){
        Account account = accountRepository.findById(id).get();
        List<AccountStockDTO> stocks = new ArrayList<>();

        for (AccountStock x : account.getAccountStocks()){
            stocks.add(new AccountStockDTO(x.getStock().getStockId(), x.getQuantity(), getTotal(x.getQuantity(), x.getStock().getStockId())));
        }

        return stocks;
    }

    private Double getTotal(Integer quantity, String stockId) {
        BrapiResponseDTO response = brapiClient.getQuote(TOKEN, stockId);
        Double price = response.getResults().getFirst().getRegularMarketPrice();
        return quantity * price;
    }

    @Transactional
    public AccountDTO insertAccountUser(Long id, AccountDTO dto){
        Account account = new Account();
        User user = userRepository.getReferenceById(id);//lembrar de tratar a exceção (pode não encontrar o usuário)
        account.setDescription(dto.getDescription());
        account.setUser(user);
        account = accountRepository.save(account);
        return new AccountDTO(account);
    }
}
