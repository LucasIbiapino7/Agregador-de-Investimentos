package com.devsuperior.agregadordeinvestimentos.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_billing_address")
public class BillingAddress {

    @Id
    private Long id;
    private String street;
    private Integer number;

    @OneToOne
    @MapsId
    private Account account;

}
