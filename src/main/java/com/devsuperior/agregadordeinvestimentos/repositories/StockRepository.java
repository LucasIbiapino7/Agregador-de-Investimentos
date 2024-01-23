package com.devsuperior.agregadordeinvestimentos.repositories;

import com.devsuperior.agregadordeinvestimentos.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, String> {
}
