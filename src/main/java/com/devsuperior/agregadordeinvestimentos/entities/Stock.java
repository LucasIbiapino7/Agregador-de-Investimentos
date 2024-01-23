package com.devsuperior.agregadordeinvestimentos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_stock")
public class Stock {

    @Id
    private String stockId;
    private String description;

    @OneToMany(mappedBy = "id.stock")
    private Set<AccountStock> accountStocks = new HashSet<>();


}
