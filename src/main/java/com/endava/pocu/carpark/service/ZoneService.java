package com.endava.pocu.carpark.service;

import com.endava.pocu.carpark.entity.Zone;
import com.endava.pocu.carpark.repository.ZoneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ZoneService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZoneService.class);
    @Autowired
    private ZoneRepository zoneRepository;
    
    /**
     * <b>POST method</b> for the Zone entity
     * @param zone
     */
    public void postZone(final Zone zone) {
        LOGGER.info("Trying to post zone: " + zone);
        if(zone == null) {
            LOGGER.info("Failed");
            throw new RuntimeException();
        } else {
            zoneRepository.save(zone);
        }
    }

    /**
     * <b>GET method</b> for the Zone entity
     * @param id
     * @return Zone or exception
     */
    public Zone getZone(Long id) {
        LOGGER.info("Trying to get zone: " + id);
        if(id == null) {
            LOGGER.info("Failed");
            throw new RuntimeException("ID is null");
        } else {
            Optional<Zone> zone = zoneRepository.findById(id);

            if(zone.isPresent()) {
                LOGGER.info("Found");
                return zone.get();
            } else {
                LOGGER.info("Not found");
                throw new RuntimeException("Could not find zone");
            }
        }
    }

    /**
     * <b>GET ALL method</b> for the zone entity
     * @return all parking lots
     */
    public List<Zone> getAllZones() {
        LOGGER.info("Trying to get all zones");

        final List<Zone> zones = new ArrayList<>();
        zoneRepository.findAll().forEach(zones::add);

        return zones;
    }

    /**
     * <b>PUT method</b> for the zone entity
     * @param id
     * @param zone
     */
    public void putZone(final Long id, Zone zone) {
        LOGGER.info("Trying to put a zone");

        Optional<Zone> oldZone = zoneRepository.findById(id);
        zone.setZone_id(id);

        oldZone.ifPresent(lot -> zoneRepository.delete(lot));

        zoneRepository.save(zone);
    }

    public void deleteZoneById(Long id) {
        Optional<Zone> zoneOptional = zoneRepository.findById(id);
        zoneOptional.ifPresent(zone -> zoneRepository.delete(zone));
    }

    public void deleteZone(Zone zone) {
        if(zone == null) {
            throw new RuntimeException("Can't delete null zone");
        } else {
            zoneRepository.delete(zone);
        }
    }
}
