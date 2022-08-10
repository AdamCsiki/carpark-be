package com.endava.pocu.carpark.service;

import com.endava.pocu.carpark.entity.Address;
import com.endava.pocu.carpark.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressService.class);
    @Autowired
    private AddressRepository addressRepository;

    /**
     * <b>POST method</b> for the Address entity
     * @param address
     */
    public void postAddress(final Address address) {
        LOGGER.info("Trying to post address: " + address);
        if(address == null) {
            LOGGER.info("Failed");
            throw new RuntimeException("Address should not be null.");
        } else {
            addressRepository.save(address);
        }
    }

    /**
     * <b>GET method</b> for the Address entity
     * @param id
     * @return Address or exception
     */
    public Address getAddress(Long id) {
        LOGGER.info("Trying to get address: " + id);
        if(id == null) {
            LOGGER.info("Failed");
            throw new RuntimeException("ID is null");
        } else {
            Optional<Address> address = addressRepository.findById(id);

            if(address.isPresent()) {
                LOGGER.info("Found");
                return address.get();
            } else {
                LOGGER.info("Not found");
                throw new RuntimeException("Could not find address");
            }
        }
    }

    /**
     * <b>GET ALL method</b> for the address entity
     * @return all parking lots
     */
    public List<Address> getAllAddresss() {
        LOGGER.info("Trying to get all addresss");

        final List<Address> addresss = new ArrayList<>();
        addressRepository.findAll().forEach(addresss::add);

        return addresss;
    }

    /**
     * <b>PUT method</b> for the address entity
     * @param id
     * @param address
     */
    public void putAddress(final Long id, Address address) {
        LOGGER.info("Trying to put a address");

        Optional<Address> oldAddress = addressRepository.findById(id);
        address.setId(id);

        oldAddress.ifPresent(lot -> addressRepository.delete(lot));

        addressRepository.save(address);
    }

    public void deleteAddressById(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        addressOptional.ifPresent(address -> addressRepository.delete(address));
    }

    public void deleteAddress(Address address) {
        if(address == null) {
            throw new RuntimeException("Can't delete null address");
        } else {
            addressRepository.delete(address);
        }
    }
}
