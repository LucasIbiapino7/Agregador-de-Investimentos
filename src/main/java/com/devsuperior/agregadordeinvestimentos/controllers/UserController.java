package com.devsuperior.agregadordeinvestimentos.controllers;

import com.devsuperior.agregadordeinvestimentos.dto.UserDTO;
import com.devsuperior.agregadordeinvestimentos.dto.UserMinDTO;
import com.devsuperior.agregadordeinvestimentos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserMinDTO> insert(@RequestBody UserDTO dto){
        UserMinDTO responseDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(responseDto);
    }


}
