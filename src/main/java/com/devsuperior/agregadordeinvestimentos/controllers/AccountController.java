package com.devsuperior.agregadordeinvestimentos.controllers;

import com.devsuperior.agregadordeinvestimentos.dto.AccountStockDTO;
import com.devsuperior.agregadordeinvestimentos.dto.StockDTO;
import com.devsuperior.agregadordeinvestimentos.services.AccountService;
import com.devsuperior.agregadordeinvestimentos.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    private StockService service;

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/{id}/stocks")
    public ResponseEntity<AccountStockDTO> insertStockAccount(@PathVariable Long id, @RequestBody AccountStockDTO dto){
        AccountStockDTO resp = service.insertStockAccount(id, dto);
        return ResponseEntity.ok(resp);
    }

    @GetMapping(value = "/{id}/stocks")
    public ResponseEntity<List<AccountStockDTO>> getStocksByAccount(@PathVariable Long id){
        List<AccountStockDTO> result = accountService.getStocksByAccount(id);
        return ResponseEntity.ok(result);
    }

}
