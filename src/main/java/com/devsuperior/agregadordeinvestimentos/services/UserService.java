package com.devsuperior.agregadordeinvestimentos.services;

import com.devsuperior.agregadordeinvestimentos.dto.*;
import com.devsuperior.agregadordeinvestimentos.entities.Account;
import com.devsuperior.agregadordeinvestimentos.entities.User;
import com.devsuperior.agregadordeinvestimentos.projections.UserAccountStocksProjection;
import com.devsuperior.agregadordeinvestimentos.repositories.AccountRepository;
import com.devsuperior.agregadordeinvestimentos.repositories.UserRepository;
import com.devsuperior.agregadordeinvestimentos.services.exceptions.DatabaseException;
import com.devsuperior.agregadordeinvestimentos.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BrapiService brapiService;

    @Transactional
    public UserMinDTO insert(UserDTO dto) {
        User user = new User();

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        user = repository.save(user);

        return new UserMinDTO(user);
    }

    @Transactional(readOnly = true)
    public UserMinDTO findById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário Não Encontrado"));
        return new UserMinDTO(user);
    }

    @Transactional(readOnly = true)
    public List<UserMinDTO> findAll() {
        List<User> result = repository.findAll();
        return result.stream().map(x -> new UserMinDTO(x)).toList();
    }

    @Transactional
    public UserMinDTO update(Long id, UserDTO dto) {
        try {
            User user = repository.getReferenceById(id);
            user.setEmail(dto.getEmail());
            user.setUsername(dto.getUsername());
            user.setPassword(dto.getPassword());
            user = repository.save(user);
            return new UserMinDTO(user);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Usuário Não Encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Usuário Não Encontrado");
        }
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Falha de Integridade Referencial");
        }

    }

    @Transactional(readOnly = true)
    public List<AccountMinDTO> getAllUserAccount(Long id){
        //Lembrar de tentar criar um método que faça apenas uma consulta no Banco
        try {
            User user = repository.getReferenceById(id);
            List<Account> accounts = user.getAccounts();
            return accounts.stream().map(x -> new AccountMinDTO(x)).toList();
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Usuário Não Encontrado");
        }
    }

    @Transactional(readOnly = true)
    public UserAccountStocksDTO getUserAccountStock(Long id) {
        List<UserAccountStocksProjection> result = accountRepository.getUserAccountStock(id);
        if (result.isEmpty()) {
            throw new ResourceNotFoundException("O Usuário não possui contas");
        }
        UserAccountStocksDTO dto = new UserAccountStocksDTO();
        dto.setUsername(result.getFirst().getUsername());

        Map<Long, AccountStockListDTO> map = new HashMap<>();

        for (UserAccountStocksProjection projection : result){
            if (!map.containsKey(projection.getAccountId())){
                map.put(projection.getAccountId(), new AccountStockListDTO(projection.getAccountId(), projection.getDescription()));
            }
            if (!(projection.getStockId() == null)){
                AccountStockListDTO test = map.get(projection.getAccountId());
                test.getAccountStock().add(
                        new AccountStockDTO(projection.getStockId(),
                                projection.getQuantity(),
                                brapiService.getTotal(projection.getQuantity(), projection.getStockId())));
            }
        }

        dto.setAccounts(map);

        return dto;
    }
}
