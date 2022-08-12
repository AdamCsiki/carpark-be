package com.endava.pocu.carpark.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @ManyToMany(mappedBy = "registeredUsers", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ParkingLot> registeredInParkingLots = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Spot> purchasedSpots;

    public User() {
    }

    public User(String firstName, String lastName, Address address, Set<ParkingLot> registeredInParkingLots, List<Spot> purchasedSpots) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.registeredInParkingLots = registeredInParkingLots;
        this.purchasedSpots = purchasedSpots;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null) {
            throw new RuntimeException("User firstName should not be null.");
        } else if(firstName.isBlank()) {
            throw new RuntimeException("User firstName should not be blank.");
        } else if(firstName.matches("[0-9]+") || firstName.matches("-[0-9]+")) {
            throw new RuntimeException("User firstName should not contain numbers.");
        } else {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null) {
            throw new RuntimeException("User lastName should not be null.");
        } else if(lastName.isBlank()) {
            throw new RuntimeException("User lastName should not be blank.");
        } else if(lastName.matches("[0-9]+") || lastName.matches("-[0-9]+")) {
            throw new RuntimeException("User lastName should not contain numbers.");
        } else {
            this.lastName = lastName;
        }
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if(address == null) {
            throw new RuntimeException("User address should not be null.");
        } else {
            this.address = address;
        }
    }

    public Set<ParkingLot> getRegisteredInParkingLots() {
        return registeredInParkingLots;
    }

    public void setRegisteredInParkingLots(Set<ParkingLot> registeredInParkingLots) {
        if(registeredInParkingLots == null) {
            throw new RuntimeException("User registeredInParkingLots should not be null");
        } else {
            this.registeredInParkingLots = registeredInParkingLots;
        }
    }

    public List<Spot> getPurchasedSpots() {
        return purchasedSpots;
    }

    public void setPurchasedSpots(List<Spot> purchasedSpots) {
        if(purchasedSpots == null) {
            throw new RuntimeException("User purchasedSpots should not be null");
        } else {
            this.purchasedSpots = purchasedSpots;
        }
    }
}
