package com.devsuperior.agregadordeinvestimentos.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private BillingAddress billingAddress;

    @OneToMany(mappedBy = "id.account")
    private Set<AccountStock> accountStocks = new HashSet<>();

}
