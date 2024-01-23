package com.devsuperior.agregadordeinvestimentos.entities;

import jakarta.persistence.*;

import java.util.Objects;

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

    public BillingAddress() {
    }

    public BillingAddress(Long id, String street, Integer number, Account account) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillingAddress that = (BillingAddress) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
