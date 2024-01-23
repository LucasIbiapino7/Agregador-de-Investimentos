package com.devsuperior.agregadordeinvestimentos.controllers;

import com.devsuperior.agregadordeinvestimentos.dto.AccountStockDTO;
import com.devsuperior.agregadordeinvestimentos.dto.StockDTO;
import com.devsuperior.agregadordeinvestimentos.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    private StockService service;

    @PostMapping(value = "/{id}/stocks")
    public ResponseEntity<String> insertStockAccount(@PathVariable Long id, @RequestBody AccountStockDTO dto){
        String resp = service.insertStockAccount(id, dto);
        return ResponseEntity.ok(resp);
    }

}
