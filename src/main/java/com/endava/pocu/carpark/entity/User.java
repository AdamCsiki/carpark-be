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
    private Set<ParkingLot> parkingLots = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Spot> purchasedSpots;

    public User() {
    }

    public User(String firstName, String lastName, Address address, Set<ParkingLot> parkingLots, List<Spot> purchasedSpots) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.parkingLots = parkingLots;
        this.purchasedSpots = purchasedSpots;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null) {
            throw new RuntimeException("User`s First Name should not be null.");
        } else if(firstName.isBlank()) {
            throw new RuntimeException("User`s First Name should not be blank.");
        } else {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null) {
            throw new RuntimeException("User`s Last Name should not be null.");
        } else if(lastName.isBlank()) {
            throw new RuntimeException("User`s Last Name should not be blank.");
        } else {
            this.lastName = lastName;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Spot> getPurchasedSpots() {
        return purchasedSpots;
    }

    public void setPurchasedSpots(List<Spot> purchasedSpots) {
        this.purchasedSpots = purchasedSpots;
    }

    public Set<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(Set<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
