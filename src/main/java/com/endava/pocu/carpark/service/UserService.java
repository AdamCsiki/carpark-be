package com.endava.pocu.carpark.service;

import com.endava.pocu.carpark.entity.ParkingLot;
import com.endava.pocu.carpark.entity.Spot;
import com.endava.pocu.carpark.entity.User;
import com.endava.pocu.carpark.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    public void postUser(final User user) {
        LOGGER.info("Trying to post user: " + user);
        if(user == null) {
            LOGGER.info("Failed");
            throw new RuntimeException();
        } else {
            userRepository.save(user);
        }
    }

    public User getUser(Long id) {
        LOGGER.info("Trying to get user: " + id);

        if(id == null) {
            LOGGER.info("Failed");
            throw new RuntimeException("ID is null");
        } else {
            Optional<User> user = userRepository.findById(id);

            if(user.isPresent()) {
                LOGGER.info("Found");
                return user.get();
            } else {
                LOGGER.info("Not found");
                throw new RuntimeException("Could not find user");
            }
        }
    }

    public List<User> getAllUsers() {
        LOGGER.info("Trying to get all users");

        final List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);

        return users;
    }

    public void putUser(final Long id, User user) {
        LOGGER.info("Trying to put a user");

        Optional<User> oldUser = userRepository.findById(id);
        user.setId(id);

        oldUser.ifPresent(lot -> userRepository.delete(lot));

        userRepository.save(user);
    }

    public void addSpotToUser(Spot spot, User user, LocalDateTime endTime) {
        if(!spot.getUsed()) {

            // adding the start date (now) and ending date to the parking slot that has been purchased
            spot.setDateStart(LocalDateTime.now());
            spot.setDateEnd(endTime);
            //

            // adding the spot to the users PurchasedSlots list
            user.getPurchasedSpots().add(spot);
            //

            userRepository.save(user);
        } else {
            throw new RuntimeException("Spot is already in use.");
        }
    }

    public void addParkingLotToUser(ParkingLot parkingLot, User user) {
        user.getRegisteredInParkingLots().add(parkingLot);
        userRepository.save(user);
    }

    public void removeSpotFromUser(Spot spot, User user) {
        user.getPurchasedSpots().remove(spot);
        userRepository.save(user);
    }

    public void removeParkingLotFromUser(ParkingLot parkingLot, User user) {
        user.getRegisteredInParkingLots().remove(parkingLot);
        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        userOptional.ifPresent(user -> userRepository.delete(user));
    }

    public void deleteUser(User user) {
        if(user == null) {
            throw new RuntimeException("Can't delete null user");
        } else {
            userRepository.delete(user);
        }
    }
}
