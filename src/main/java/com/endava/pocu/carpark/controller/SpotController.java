package com.endava.pocu.carpark.controller;

import com.endava.pocu.carpark.entity.Spot;
import com.endava.pocu.carpark.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/spots")
public class SpotController {
    @Autowired
    private SpotService spotService;

    @PostMapping(path = "/")
    public void post(@RequestBody Spot spot) {
        spotService.postSpot(spot);
    }

    @GetMapping(path = "/{id}")
    public Spot get(@PathVariable Long id) {
        return spotService.getSpot(id);
    }

    @PutMapping(path = "/")
    public void put(@RequestBody Long id, @RequestBody Spot spot) {
        spotService.putSpot(id, spot);
    }

    @GetMapping(path = "/")
    public List<Spot> getAll() {
        return spotService.getAllSpots();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
        spotService.deleteSpotById(id);
    }

    @DeleteMapping(path = "/")
    public void delete(@RequestBody Spot spot) {
        spotService.deleteSpot(spot);
    }
}
