package com.endava.pocu.carpark.entity;

import org.springframework.format.annotation.DateTimeFormat;

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

    @Column(nullable = true)
    private LocalDateTime dateStart;

    @Column(nullable = true)
    private LocalDateTime dateEnd;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parking_id")
    private ParkingLot parkingLot;

    public Spot() {
    }

    public Spot(Double price, Boolean used, LocalDateTime dateStart, LocalDateTime dateEnd) {
        this.price = price;
        this.used = used;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if(price == null) {
            throw new RuntimeException("Spot price should not be null");
        } else if(price < 0) {
            throw new RuntimeException("Spot price should be higher or equal to 0");
        } else {
            this.price = price;
        }
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        if(used == null) {
            throw new RuntimeException("Spot isUsed should not be null");
        } else {
            this.used = used;
        }
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        if(dateEnd != null && dateStart.isAfter(dateEnd)) {
            throw new RuntimeException("Spot dateStart should be before ending date");
        } else {
            this.dateStart = dateStart;
        }
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        if(dateStart != null && dateEnd.isBefore(dateStart)) {
            throw new RuntimeException("Spot dateEnd should be after starting date");
        } else {
            this.dateEnd = dateEnd;
        }
    }

}
