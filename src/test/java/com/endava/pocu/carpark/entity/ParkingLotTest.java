package com.endava.pocu.carpark.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParkingLotTest {
    private ParkingLot parkingLot;
    private Address address;
    private ArrayList<User> users;

    @BeforeEach
    void init() {
        this.parkingLot = new ParkingLot();
        this.address = new Address();
        this.users = new ArrayList<>();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "     Parking",
            "Steve       ",
    })
    void nameShouldNotBeDifferentFromInput(String testName) {
        parkingLot.setName(testName);
        assertThat(parkingLot.getName()).isEqualTo(testName);
    }

    @Test
    void nameShouldThrowExceptionIfBlank() {
        assertThatThrownBy(() -> parkingLot.setName(" "))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("ParkingLot name should not be blank");
    }

    @Test
    void nameShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> parkingLot.setName(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("ParkingLot name should not be null");
    }

    @Test
    void adressShouldNotBeDiffrentFromInput() {
        Address testAddress = new Address("Marghita", "Republicii", 112);
        parkingLot.setAddress(testAddress);
        assertThat(parkingLot.getAddress()).isEqualTo(testAddress);
    }

    @Test
    void addressShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> parkingLot.setAddress(null)).hasMessage("ParkingLot address should not be null");
    }

    @Test
    void usersShouldNotBeDiffrentFromInput() {
        users.add(new User());
        parkingLot.setRegisteredUsers(users);
        assertThat(parkingLot.getRegisteredUsers()).isEqualTo(users);
    }
    @Test
    void usersShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> parkingLot.setRegisteredUsers(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("ParkingLot users should not be null");
    }

    @Test
    void usersShouldNotThrowExceptionIfEmptyList() {
        parkingLot.setRegisteredUsers(new ArrayList<>());
        assertThat(parkingLot.getRegisteredUsers())
                .isInstanceOf(RuntimeException.class)
                .isEqualTo(new ArrayList<>());
    }
}