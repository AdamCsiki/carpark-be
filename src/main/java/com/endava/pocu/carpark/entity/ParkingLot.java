package com.endava.pocu.carpark.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "parkings")
@AllArgsConstructor
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 32, nullable = false)
    private String name;

    @Column(length = 32, nullable = false)
    private String companyName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "parkingLot", targetEntity = Spot.class, cascade = CascadeType.ALL)
    private Set<Spot> spots;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "registered_users",
            joinColumns = @JoinColumn(name = "parking_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonIgnore
    private List<User> registeredUsers;

    public ParkingLot() {
    }

    public ParkingLot(String name, String companyName, Address address, Set<Spot> spots, List<User> users) {
        this.name = name;
        this.companyName = companyName;
        this.address = address;
        this.spots = spots;
        this.registeredUsers = users;
    }

    public ParkingLot(String name, String companyName, Address address, Set<Spot> spots) {
        this.name = name;
        this.companyName = companyName;
        this.address = address;
        this.spots = spots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null) {
            throw new RuntimeException("ParkingLot name should not be null");
        } else if(name.isBlank()) {
            throw new RuntimeException("ParkingLot name should not be blank");
        } else {
            this.name = name;
        }
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if(address == null) {
            throw new RuntimeException("ParkingLot address should not be null");
        } else {
            this.address = address;
        }
    }

    public List<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(List<User> users) {
        if(users == null) {
            throw new RuntimeException("ParkingLot users should not be null");
        } else {
            this.registeredUsers = users;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
