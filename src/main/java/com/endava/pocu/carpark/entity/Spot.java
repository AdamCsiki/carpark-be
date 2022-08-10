package com.endava.pocu.carpark.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "spots")
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Boolean used;

    @Column
    private LocalDateTime dateStart;

    @Column
    private LocalDateTime dateEnd;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parking_id", nullable = false)
    private ParkingLot parkingLot;

    public Spot() {
    }

    public Spot(Double price, Boolean used, LocalDateTime dateStart, LocalDateTime dateEnd) {
        this.price = price;
        this.used = used;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
