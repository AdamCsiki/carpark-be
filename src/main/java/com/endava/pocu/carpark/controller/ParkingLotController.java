package com.endava.pocu.carpark.controller;

import com.endava.pocu.carpark.entity.ParkingLot;
import com.endava.pocu.carpark.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/parkings")
public class ParkingLotController {
    @Autowired
    private ParkingLotService parkingLotService;

    @PostMapping(path = "/")
    public void post(@RequestBody ParkingLot parkingLot) {
        parkingLotService.postParkingLot(parkingLot);
    }

    @GetMapping(path = "/{id}")
    public ParkingLot get(@PathVariable Long id) {
        return parkingLotService.getParkingLot(id);
    }

    @PutMapping(path = "/")
    public void put(@RequestBody Long id, @RequestBody ParkingLot parkingLot) {
        parkingLotService.putParkingLot(id, parkingLot);
    }

    @GetMapping(path = "/")
    public List<ParkingLot> getAll() {
        return parkingLotService.getAllParkingLots();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
        parkingLotService.deleteParkingLotById(id);
    }

    @DeleteMapping(path = "/")
    public void delete(@RequestBody ParkingLot parkingLot) {
        parkingLotService.deleteParkingLot(parkingLot);
    }
}
