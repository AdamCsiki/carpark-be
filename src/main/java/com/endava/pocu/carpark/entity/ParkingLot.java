package com.endava.pocu.carpark.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long park_id;

    @Column(length = 32)
    private String name;

    @OneToOne
    private Address address;

    @OneToMany
    private List<Zone> zones;

    public ParkingLot() {
    }

    public ParkingLot(String name, Address address, List<Zone> zones) {
        this.name = name;
        this.address = address;
        this.zones = zones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null) {
            throw new RuntimeException("ParkingLot name should not be null.");
        } else {
            this.name = name;
        }
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if(address == null) {
            throw new RuntimeException("ParkingLot address should not be null.");
        } else {
            this.address = address;
        }
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        if(zones.isEmpty()) {
            throw new RuntimeException("ParkingLot zones should not be null.");
        } else {
            this.zones = zones;
        }
    }
}
