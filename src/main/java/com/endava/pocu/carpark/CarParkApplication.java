package com.endava.pocu.carpark;

import com.endava.pocu.carpark.controller.ParkingLotController;
import com.endava.pocu.carpark.controller.SpotController;
import com.endava.pocu.carpark.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarParkApplication {
	@Autowired
	private ParkingLotController parkingLotController;
	@Autowired
	private SpotController spotController;
	@Autowired
	private UserController userController;

	public static void main(String[] args) {
		SpringApplication.run(CarParkApplication.class, args);
	}

}
