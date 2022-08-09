package com.endava.pocu.carpark.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parkings")
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_id")
    private Long id;

    @Column(length = 32)
    private String name;

    @Column(length = 32, nullable = true)
    private String companyName;

    @OneToOne
    private Address address;

    @OneToMany
    private List<Zone> zones;

    @ManyToMany
    @JoinTable(
            name = "parking_users",
            joinColumns = @JoinColumn(name = "parking_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    public ParkingLot() {
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

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        if(zones == null) {
            throw new RuntimeException("ParkingLot zones should not be null");
        } else if(zones.isEmpty()) {
            throw new RuntimeException("ParkingLot zones should not be empty");
        } else {
            this.zones = zones;
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        if(users == null) {
            throw new RuntimeException("ParkingLot users should not be null");
        } else {
            this.users = users;
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
