package com.endava.pocu.carpark.entity;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;

    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
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
            throw new RuntimeException("Trying to set a NULL city.");
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if(street != null) {
            this.street = street;
        } else {
            throw new RuntimeException("Trying to set a NULL street name.");
        }

    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        if(number == null) {
            throw new RuntimeException("Trying to set NULL street number.");
        } else if(number <= 0) {
            throw new RuntimeException("Street number needs to be over 0.");
        } else {
            this.number = number;
        }
    }
}
