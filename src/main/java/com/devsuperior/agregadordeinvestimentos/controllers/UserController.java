package com.devsuperior.agregadordeinvestimentos.controllers;

import com.devsuperior.agregadordeinvestimentos.dto.AccountDTO;
import com.devsuperior.agregadordeinvestimentos.dto.AccountMinDTO;
import com.devsuperior.agregadordeinvestimentos.dto.UserDTO;
import com.devsuperior.agregadordeinvestimentos.dto.UserMinDTO;
import com.devsuperior.agregadordeinvestimentos.services.AccountService;
import com.devsuperior.agregadordeinvestimentos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<UserMinDTO> insert(@RequestBody UserDTO dto){
        UserMinDTO responseDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(responseDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserMinDTO> findById(@PathVariable Long id){
        UserMinDTO response = service.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<UserMinDTO>> findAll(){
        List<UserMinDTO> result = service.findAll();
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserMinDTO> update(@PathVariable Long id, @RequestBody UserDTO dto){
        UserMinDTO result = service.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/{id}/accounts")
    public ResponseEntity<AccountDTO> insertAccountUser(@PathVariable Long id, @RequestBody AccountDTO dto){
        dto = accountService.insertAccountUser(id, dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping(value = "/{id}/accounts")
    public ResponseEntity<List<AccountMinDTO>> getAllUserAccount(@PathVariable Long id){
        List<AccountMinDTO> result = service.getAllUserAccount(id);
        return ResponseEntity.ok(result);
    }


}
