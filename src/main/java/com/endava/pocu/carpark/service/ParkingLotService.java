package com.endava.pocu.carpark.service;

import com.endava.pocu.carpark.entity.ParkingLot;
import com.endava.pocu.carpark.entity.Spot;
import com.endava.pocu.carpark.entity.User;
import com.endava.pocu.carpark.repository.ParkingLotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingLotService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParkingLotService.class);

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    /**
     * <b>POST method</b>
     * @param parkingLot
     */
    public void postParkingLot(final ParkingLot parkingLot) {
        LOGGER.info("Trying to post parkingLot: " + parkingLot);
        if(parkingLot == null) {
            LOGGER.info("Failed");
            throw new RuntimeException();
        } else {
            parkingLotRepository.save(parkingLot);
        }
    }

    /**
     * <b>GET method</b>
     * @param id
     * @return ParkingLot or exception
     */
    public ParkingLot getParkingLot(Long id) {
        LOGGER.info("Trying to get parkingLot: " + id);
        if(id == null) {
            LOGGER.info("Failed");
            throw new RuntimeException("ID is null");
        } else {
            Optional<ParkingLot> parkingLot = parkingLotRepository.findById(id);

            if(parkingLot.isPresent()) {
                LOGGER.info("Found");
                return parkingLot.get();
            } else {
                LOGGER.info("Not found");
                throw new RuntimeException("Could not find parkingLot");
            }
        }
    }

    /**
     * <b>GET ALL method</b>
     * @return all parking lots
     */
    public List<ParkingLot> getAllParkingLots() {
        LOGGER.info("Trying to get all parkingLots");

        final List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLotRepository.findAll().forEach(parkingLots::add);

        return parkingLots;
    }

    /**
     * <b>PUT method</b>
     * @param id
     * @param parkingLot
     */
    public void putParkingLot(final Long id, ParkingLot parkingLot) {
        LOGGER.info("Trying to put a parkingLot");

        Optional<ParkingLot> oldParkingLot = parkingLotRepository.findById(id);
        parkingLot.setId(id);

        oldParkingLot.ifPresent(lot -> parkingLotRepository.delete(lot));

        parkingLotRepository.save(parkingLot);
    }

    /**
     * <b>DELETE method</b>
     * @param id
     */
    public void deleteParkingLotById(Long id) {
        parkingLotRepository.deleteById(id);
    }

    public void deleteParkingLot(ParkingLot parkingLot) {
        if(parkingLot == null) {
            throw new RuntimeException("Can't delete null parkingLot");
        } else {
            parkingLotRepository.delete(parkingLot);
        }
    }

    public void putSpotInParkingLot(ParkingLot parkingLot, Spot spot) {
        parkingLot.getSpots().add(spot);
        parkingLotRepository.save(parkingLot);
    }
}
