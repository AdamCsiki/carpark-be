package com.endava.pocu.carpark.repository;

import com.endava.pocu.carpark.entity.ParkingLot;
import com.endava.pocu.carpark.entity.Spot;
import org.springframework.data.repository.CrudRepository;

public interface SpotRepository extends CrudRepository<Spot, Long> {
    Iterable<Spot> findAllByParkingLot(ParkingLot parkingLot);
    void deleteAllByParkingLot(ParkingLot parkingLot);
}
