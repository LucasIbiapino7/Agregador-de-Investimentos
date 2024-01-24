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
import com.devsuperior.agregadordeinvestimentos.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BrapiService brapiService;

    @Transactional(readOnly = true)
    public List<AccountStockDTO> getStocksByAccount(Long id){
        Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Conta Não Encontrada"));
        List<AccountStockDTO> stocks = new ArrayList<>();
        for (AccountStock accountStock : account.getAccountStocks()){
            stocks.add(new AccountStockDTO(accountStock.getStock().getStockId(),
                    accountStock.getQuantity(),
                    brapiService.getTotal(accountStock.getQuantity(), accountStock.getStock().getStockId())));
        }
        return stocks;
    }

    @Transactional
    public AccountDTO insertAccountUser(Long id, AccountDTO dto){
        try {
            Account account = new Account();
            User user = userRepository.getReferenceById(id);//lembrar de tratar a exceção (pode não encontrar o usuário)
            account.setDescription(dto.getDescription());
            account.setUser(user);
            account = accountRepository.save(account);
            return new AccountDTO(account);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Usuário Não encontrado");
        }
    }
}
