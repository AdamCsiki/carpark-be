package com.endava.pocu.carpark.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Spot {
    @Id
    @GeneratedValue
    private Long spot_id;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Boolean used;

    @Column
    private LocalDateTime dateStart;

    @Column
    private LocalDateTime dateEnd;

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
        if(price == null) {
            throw new RuntimeException("Spot price is null.");
        } else {
            this.price = price;
        }
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
}
