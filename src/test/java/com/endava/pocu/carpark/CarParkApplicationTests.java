package com.endava.pocu.carpark;

import com.endava.pocu.carpark.repository.AddressRepository;
import com.endava.pocu.carpark.repository.ParkingLotRepository;
import com.endava.pocu.carpark.repository.SpotRepository;
import com.endava.pocu.carpark.repository.UserRepository;
import com.endava.pocu.carpark.service.AddressService;
import com.endava.pocu.carpark.service.ParkingLotService;
import com.endava.pocu.carpark.service.SpotService;
import com.endava.pocu.carpark.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class CarParkApplicationTests {
	@Autowired
	private AddressService addressService;
	@Autowired
	private ParkingLotService parkingLotService;
	@Autowired
	private SpotService spotService;
	@Autowired
	private UserService userService;

	@MockBean
	private AddressRepository addressRepository;
	@MockBean
	private ParkingLotRepository parkingLotRepository;
	@MockBean
	private SpotRepository spotRepository;
	@MockBean
	private UserRepository userRepository;

}
