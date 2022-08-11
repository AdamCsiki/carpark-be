package com.endava.pocu.carpark.controller;

import com.endava.pocu.carpark.entity.ParkingLot;
import com.endava.pocu.carpark.entity.Spot;
import com.endava.pocu.carpark.entity.User;
import com.endava.pocu.carpark.service.ParkingLotService;
import com.endava.pocu.carpark.service.SpotService;
import com.endava.pocu.carpark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SpotService spotService;
    @Autowired
    private ParkingLotService parkingLotService;

    @PostMapping(path = "/")
    public void postUser(@RequestBody User user) {
        userService.postUser(user);
    }

    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping(path = "/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}/spots")
    public List<Spot> getUserSpots(@PathVariable Long id) {
        return userService.getUser(id).getPurchasedSpots();
    }

    @GetMapping(path = "/{id}/parkings")
    public Set<ParkingLot> getUserRegisteredInParkingLots(@PathVariable Long id) {
        return userService.getUser(id).getRegisteredInParkingLots();
    }

    @PutMapping(path = "/")
    public void putUser(@RequestBody Long id, @RequestBody User user) {
        userService.putUser(id, user);
    }

    @PutMapping(path = "/{userId}/spots/{spotId}")
    public void putUserSpot(@PathVariable Long userId, @PathVariable Long spotId, @RequestBody LocalDateTime endTime) {
        // get spot and user from the id
        Spot spot = spotService.getSpot(spotId);
        User user = userService.getUser(userId);

        userService.addSpotToUser(spot, user, endTime);
    }

    @PutMapping(path = "/{userId}/parkings/{parkingId}")
    public void putUserParking(@PathVariable Long userId, @PathVariable Long parkingId) {
        // get parking and user from the id's
        ParkingLot parkingLot = parkingLotService.getParkingLot(parkingId);
        User user = userService.getUser(userId);

        userService.addParkingLotToUser(parkingLot, user);
    }
}
