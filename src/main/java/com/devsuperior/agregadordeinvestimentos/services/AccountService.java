package com.devsuperior.agregadordeinvestimentos.services;

import com.devsuperior.agregadordeinvestimentos.dto.AccountDTO;
import com.devsuperior.agregadordeinvestimentos.entities.Account;
import com.devsuperior.agregadordeinvestimentos.entities.User;
import com.devsuperior.agregadordeinvestimentos.repositories.AccountRepository;
import com.devsuperior.agregadordeinvestimentos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

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
