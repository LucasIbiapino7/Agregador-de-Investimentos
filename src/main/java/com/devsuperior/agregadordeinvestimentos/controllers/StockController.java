package com.devsuperior.agregadordeinvestimentos.controllers;

import com.devsuperior.agregadordeinvestimentos.dto.StockDTO;
import com.devsuperior.agregadordeinvestimentos.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/stocks")
public class StockController {

    @Autowired
    private StockService service;

    @PostMapping
    public ResponseEntity<StockDTO> insert(@RequestBody StockDTO dto){
        dto = service.insert(dto);
        return ResponseEntity.ok(dto);
    }

}
