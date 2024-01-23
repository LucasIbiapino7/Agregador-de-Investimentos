package com.devsuperior.agregadordeinvestimentos.dto;

import com.devsuperior.agregadordeinvestimentos.entities.Account;

public class AccountMinDTO {

    private Long id;
    private String description;

    public AccountMinDTO() {
    }

    public AccountMinDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public AccountMinDTO(Account entity) {
        id = entity.getId();
        description = entity.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
