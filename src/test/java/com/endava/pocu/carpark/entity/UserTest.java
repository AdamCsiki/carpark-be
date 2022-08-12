package com.endava.pocu.carpark.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class UserTest {
    private User user;
    private Address address;
    private Set<ParkingLot> registeredInParkingLots;
    private List<Spot> purchasedSlots;

    @BeforeEach
    void init() {
        user = new User();
        address = new Address();
        registeredInParkingLots = new HashSet<>();
        purchasedSlots = new ArrayList<>();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "name",
            "    name",
            "name    "
    })
    void firstNameShouldNotBeDifferentFromInput(String firstName) {
        user.setFirstName(firstName);
        assertThat(user.getFirstName()).isEqualTo(firstName);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0",
            "1",
            "999",
            "-999"
    })
    void firstNameShouldThrowExceptionIfNumber(String firstName) {
        assertThatThrownBy(() -> user.setFirstName(firstName))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("User firstName should not contain numbers");
    }

    @Test
    void firstNameShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> user.setFirstName(null)).isInstanceOf(RuntimeException.class).hasMessageContaining("User firstName should not be null");
    }

    @Test
    void firstNameShouldThrowExceptionIfBlank() {
        assertThatThrownBy(() -> user.setFirstName(" "))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("User firstName should not be blank");
    }
    
    @ParameterizedTest
    @CsvSource(value = {
            "name",
            "    name",
            "name    "
    })
    void lastNameShouldNotBeDifferentFromInput(String lastName) {
        user.setLastName(lastName);
        assertThat(user.getLastName()).isEqualTo(lastName);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0",
            "1",
            "999",
            "-999"
    })
    void lastNameShouldThrowExceptionIfNumber(String lastName) {
        assertThatThrownBy(() -> user.setLastName(lastName))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("User lastName should not contain numbers");
    }

    @Test
    void lastNameShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> user.setLastName(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("User lastName should not be null");
    }

    @Test
    void lastNameShouldThrowExceptionIfBlank() {
        assertThatThrownBy(() -> user.setLastName(" "))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("User lastName should not be blank");
    }

    @Test
    void addressShouldNotBeDifferentFromInput() {
        user.setAddress(address);
        assertThat(user.getAddress()).isEqualTo(address);
    }

    @Test
    void addressShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> user.setAddress(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("User address should not be null");
    }

    @Test
    void registeredParkingLotsShouldNotBeDiffrentFromInput() {
        user.setRegisteredInParkingLots(registeredInParkingLots);
        assertThat(user.getRegisteredInParkingLots()).isEqualTo(registeredInParkingLots);
    }

    @Test
    void registeredParkingLotsShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> user.setRegisteredInParkingLots(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("User registeredInParkingLots should not be null");
    }

    @Test
    void purchasedSlotsShouldNotBeDifferentFromInput() {
        user.setPurchasedSpots(purchasedSlots);
        assertThat(user.getPurchasedSpots()).isEqualTo(purchasedSlots);
    }

    @Test
    void purchasedSlotsShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> user.setPurchasedSpots(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("User purchasedSpots should not be null");
    }

}