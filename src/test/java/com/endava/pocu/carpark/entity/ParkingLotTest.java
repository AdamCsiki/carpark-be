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

    @BeforeEach
    void init() {
        this.parkingLot = new ParkingLot();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "     Parking",
            "Steve       ",
    })
    void parkingLotNameShouldNotBeDifferentFromInput(String testName) {
        parkingLot.setName(testName);
        assertThat(parkingLot.getName()).isEqualTo(testName);
    }

    @Test
    void parkingLotNameShouldThrowExceptionIfBlank() {
        assertThatThrownBy(() -> parkingLot.setName(" ")).hasMessage("ParkingLot name should not be blank");
    }

    @Test
    void parkingLotNameShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> parkingLot.setName(null)).hasMessage("ParkingLot name should not be null");
    }

    @Test
    void parkingLotAdressShouldNotBeDiffrentFromInput() {
        Address testAddress = new Address("Marghita", "Republicii", 112);

        parkingLot.setAddress(testAddress);

        assertThat(parkingLot.getAddress()).isEqualTo(testAddress);
    }

    @Test
    void parkingLotAddressShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> parkingLot.setAddress(null)).hasMessage("ParkingLot address should not be null");
    }

    @Test
    void parkingLotZonesShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> parkingLot.setZones(null)).hasMessage("ParkingLot zones should not be null");
    }

    @Test
    void parkingLotZonesShouldThrowExceptionIfEmpty() {
        assertThatThrownBy(() -> parkingLot.setZones(new ArrayList<>())).hasMessage("ParkingLot zones should not be empty");
    }

    @Test
    void parkingLotUsersListShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> parkingLot.setUsers(null)).hasMessage("ParkingLot users should not be null");
    }

}