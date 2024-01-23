package com.devsuperior.agregadordeinvestimentos.dto;

import com.devsuperior.agregadordeinvestimentos.entities.Account;

public class AccountDTO {

    private Long id;
    private String description;
    private String userName;
    private Long userId;

    public AccountDTO() {
    }

    public AccountDTO(Long id, String description, String userName, Long userId) {
        this.id = id;
        this.description = description;
        this.userName = userName;
        this.userId = userId;
    }

    public AccountDTO(Account entity) {
        id = entity.getId();
        description = entity.getDescription();
        userName = entity.getUser().getUsername();
        userId = entity.getUser().getId();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getUserName() {
        return userName;
    }

    public Long getUserId() {
        return userId;
    }
}
