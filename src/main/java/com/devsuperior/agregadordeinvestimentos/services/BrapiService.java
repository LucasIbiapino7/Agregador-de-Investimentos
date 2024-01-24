package com.devsuperior.agregadordeinvestimentos.services;

import com.devsuperior.agregadordeinvestimentos.client.BrapiClient;
import com.devsuperior.agregadordeinvestimentos.client.dto.BrapiResponseDTO;
import com.devsuperior.agregadordeinvestimentos.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BrapiService {


    @Value("#{environment.TOKEN}")
    private String TOKEN;

    @Autowired
    private BrapiClient brapiClient;

    protected Double getTotal(Integer quantity, String stockId) {
        try {
            BrapiResponseDTO response = brapiClient.getQuote(TOKEN, stockId);
            Double price = response.getResults().getFirst().getRegularMarketPrice();
            return quantity * price;
        }catch (Exception e){
            throw new ResourceNotFoundException("Recurso Não Existe na Brapi");
        }
    }

}
