package com.devsuperior.agregadordeinvestimentos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_stock")
public class Stock {

    @Id
    private String stockId;
    private String description;

    @OneToMany(mappedBy = "id.stock")
    private Set<AccountStock> accountStocks = new HashSet<>();

    public Stock() {
    }

    public Stock(String stockId, String description) {
        this.stockId = stockId;
        this.description = description;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<AccountStock> getAccountStocks() {
        return accountStocks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        return Objects.equals(stockId, stock.stockId);
    }

    @Override
    public int hashCode() {
        return stockId != null ? stockId.hashCode() : 0;
    }
}
