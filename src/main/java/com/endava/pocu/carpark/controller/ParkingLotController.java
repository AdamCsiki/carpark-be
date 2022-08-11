package com.endava.pocu.carpark.controller;

import com.endava.pocu.carpark.entity.ParkingLot;
import com.endava.pocu.carpark.entity.Spot;
import com.endava.pocu.carpark.entity.User;
import com.endava.pocu.carpark.service.ParkingLotService;
import com.endava.pocu.carpark.service.SpotService;
import com.endava.pocu.carpark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/parkings")
public class ParkingLotController {
    @Autowired
    private ParkingLotService parkingLotService;
    @Autowired
    private SpotService spotService;
    @Autowired
    private UserService userService;

    @PostMapping(path = "/")
    public void postParkingLot(@RequestBody ParkingLot parkingLot) {
        parkingLotService.postParkingLot(parkingLot);
    }

    @GetMapping(path = "/{id}")
    public ParkingLot getParkingLot(@PathVariable Long id) {
        return parkingLotService.getParkingLot(id);
    }

    @GetMapping(path = "/{id}/spots")
    public List<Spot> getAllParkingLotSpots(@PathVariable Long id) {
        return spotService.getAllSpotsByParkingLot(getParkingLot(id));
    }

    @GetMapping(path = "/")
    public List<ParkingLot> getAllParkingLots() {
        return parkingLotService.getAllParkingLots();
    }

    @GetMapping(path = "/{parkingId}/users")
    public List<User> getParkingLotUsers(@PathVariable Long parkingId) {
        return parkingLotService.getParkingLot(parkingId).getRegisteredUsers();
    }

    @PutMapping(path = "/{parkingId}/users/{userId}")
    public void putUserInParkingLot(@PathVariable Long parkingId, @PathVariable Long userId) {
        User user = userService.getUser(userId);

        ParkingLot parkingLot = parkingLotService.getParkingLot(parkingId);
        parkingLot.getRegisteredUsers().add(user);

        parkingLotService.postParkingLot(parkingLot);
    }

    @PutMapping(path = "/{parkingId}/users")
    public void putUserInParkingLot(@PathVariable Long parkingId, @RequestBody User user) {
        ParkingLot parkingLot = parkingLotService.getParkingLot(parkingId);
        parkingLot.getRegisteredUsers().add(user);
        parkingLotService.postParkingLot(parkingLot);
    }


    @DeleteMapping(path = "/{id}")
    public void deleteParkingLotById(@PathVariable Long id) {
        parkingLotService.deleteParkingLotById(id);
    }

    @DeleteMapping(path = "/")
    public void deleteParkingLot(@RequestBody ParkingLot parkingLot) {
        parkingLotService.deleteParkingLot(parkingLot);
    }

}
