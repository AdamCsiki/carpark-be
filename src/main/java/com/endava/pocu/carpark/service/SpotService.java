package com.endava.pocu.carpark.service;

import com.endava.pocu.carpark.entity.Spot;
import com.endava.pocu.carpark.repository.SpotRepository;
import com.endava.pocu.carpark.repository.SpotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpotService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpotService.class);
    @Autowired
    private SpotRepository spotRepository;

    /**
     * <b>POST method</b> for the Spot entity
     * @param spot
     */
    public void postSpot(final Spot spot) {
        LOGGER.info("Trying to post spot: " + spot);
        if(spot == null) {
            LOGGER.info("Failed");
            throw new RuntimeException();
        } else {
            spotRepository.save(spot);
        }
    }

    /**
     * <b>GET method</b> for the Spot entity
     * @param id
     * @return Spot or exception
     */
    public Spot getSpot(Long id) {
        LOGGER.info("Trying to get spot: " + id);
        if(id == null) {
            LOGGER.info("Failed");
            throw new RuntimeException("ID is null");
        } else {
            Optional<Spot> spot = spotRepository.findById(id);

            if(spot.isPresent()) {
                LOGGER.info("Found");
                return spot.get();
            } else {
                LOGGER.info("Not found");
                throw new RuntimeException("Could not find spot");
            }
        }
    }

    /**
     * <b>GET ALL method</b> for the spot entity
     * @return all parking lots
     */
    public List<Spot> getAllSpots() {
        LOGGER.info("Trying to get all spots");

        final List<Spot> spots = new ArrayList<>();
        spotRepository.findAll().forEach(spots::add);

        return spots;
    }

    /**
     * <b>PUT method</b> for the spot entity
     * @param id
     * @param spot
     */
    public void putSpot(final Long id, Spot spot) {
        LOGGER.info("Trying to put a spot");

        Optional<Spot> oldSpot = spotRepository.findById(id);
        spot.setSpot_id(id);

        oldSpot.ifPresent(lot -> spotRepository.delete(lot));

        spotRepository.save(spot);
    }

    public void deleteSpotById(Long id) {
        Optional<Spot> spotOptional = spotRepository.findById(id);
        spotOptional.ifPresent(spot -> spotRepository.delete(spot));
    }

    public void deleteSpot(Spot spot) {
        if(spot == null) {
            throw new RuntimeException("Can't delete null spot");
        } else {
            spotRepository.delete(spot);
        }
    }
}
