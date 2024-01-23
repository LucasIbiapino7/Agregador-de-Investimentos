package com.devsuperior.agregadordeinvestimentos.services;

import com.devsuperior.agregadordeinvestimentos.dto.AccountDTO;
import com.devsuperior.agregadordeinvestimentos.dto.AccountMinDTO;
import com.devsuperior.agregadordeinvestimentos.dto.UserDTO;
import com.devsuperior.agregadordeinvestimentos.dto.UserMinDTO;
import com.devsuperior.agregadordeinvestimentos.entities.Account;
import com.devsuperior.agregadordeinvestimentos.entities.User;
import com.devsuperior.agregadordeinvestimentos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

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
        User user = repository.findById(id).get();
        return new UserMinDTO(user);
    }

    @Transactional(readOnly = true)
    public List<UserMinDTO> findAll() {
        List<User> result = repository.findAll();
        return result.stream().map(x -> new UserMinDTO(x)).toList();
    }

    @Transactional
    public UserMinDTO update(Long id, UserDTO dto) {
        User user = repository.getReferenceById(id);
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user = repository.save(user);
        return new UserMinDTO(user);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<AccountMinDTO> getAllUserAccount(Long id){
        //Lembrar de tentar criar um método que faça apenas uma consulta no Banco
        //Lembrar de tratar as exceções
        User user = repository.getReferenceById(id);
        List<Account> accounts = user.getAccounts();
        return accounts.stream().map(x -> new AccountMinDTO(x)).toList();
    }
}
