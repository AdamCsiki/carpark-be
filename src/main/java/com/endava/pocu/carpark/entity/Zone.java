package com.endava.pocu.carpark.entity;

import javax.persistence.*;

@Entity
@Table(name = "zones")
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zone_id")
    private Long id;

    @Column(length = 32)
    private String name;

    @Column
    private Integer floor;

    @Column
    private Boolean isFull;

    @Column
    private Integer numberOfSpots;

    public Zone() {
    }

    public Zone(String name, Integer floor, Boolean isFull, Integer numberOfSpots) {
        this.name = name;
        this.floor = floor;
        this.isFull = isFull;
        this.numberOfSpots = numberOfSpots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null) {
            throw new RuntimeException("Zone name should not be null.");
        } else if(name.length() == 0) {
            throw new RuntimeException("Name should not be empty.");
        } else {
            this.name = name;
        }
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        if(floor == null) {
            throw new RuntimeException("Zone floor should not be null.");
        } else {
            this.floor = floor;
        }
    }

    public Boolean getFull() {
        return isFull;
    }

    public void setFull(Boolean full) {
        if(full == null) {
            throw new RuntimeException("Zone isFull should not be null.");
        } else {
            this.isFull = full;
        }
    }

    public Integer getNumberOfSpots() {
        return numberOfSpots;
    }

    public void setNumberOfSpots(Integer numberOfSpots) {
        if(numberOfSpots == null) {
            throw new RuntimeException("Zone numberOfSlots should not be null");
        } else {
            this.numberOfSpots = numberOfSpots;
        }
    }

    public Long getZone_id() {
        return id;
    }

    public void setZone_id(Long id) {
        this.id = id;
    }
}
