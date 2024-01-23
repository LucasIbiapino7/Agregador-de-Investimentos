package com.devsuperior.agregadordeinvestimentos.dto;

import com.devsuperior.agregadordeinvestimentos.entities.User;

public class UserMinDTO {
    private Long id;
    private String username;
    private String email;

    public UserMinDTO() {
    }

    public UserMinDTO(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public UserMinDTO(User entity) {
        id = entity.getId();
        username = entity.getUsername();
        email = entity.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
