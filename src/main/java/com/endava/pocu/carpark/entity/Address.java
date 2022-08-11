package com.endava.pocu.carpark.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String city;
    @Column(length = 30)
    private String street;
    @Column
    private Integer number;

    public Address() {
    }

    public Address(String city, String street, Integer number) {
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city != null) {
            this.city = city;
        } else {
            throw new RuntimeException("Address city should not be null");
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if(street != null) {
            this.street = street;
        } else {
            throw new RuntimeException("Address street should not be null.");
        }

    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        if(number == null) {
            throw new RuntimeException("Address number should not be null.");
        } else if(number <= 0) {
            throw new RuntimeException("Address number needs to be over 0.");
        } else {
            this.number = number;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
