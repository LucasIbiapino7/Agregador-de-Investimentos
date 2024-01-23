package com.devsuperior.agregadordeinvestimentos.services;

import com.devsuperior.agregadordeinvestimentos.dto.UserDTO;
import com.devsuperior.agregadordeinvestimentos.dto.UserMinDTO;
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
}
