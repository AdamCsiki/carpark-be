package com.endava.pocu.carpark.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class AddressTest {
    Address address;

    @BeforeEach
    void init() {
        address = new Address();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "city   ",
            "   city"
    })
    void cityShouldNotBeDifferentFromInput(String city) {
        address.setCity(city);
        assertThat(address.getCity()).isEqualTo(city);
    }

    @Test
    void cityShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> address.setCity(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Address city");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "street",
            "street    ",
            "   street"
    })
    void streetShouldNotBeDifferentFromInput(String street) {
        address.setStreet(street);
        assertThat(address.getStreet()).isEqualTo(street);
    }

    @Test
    void streetShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> address.setStreet(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Address street");
    }

    @Test
    void numberShouldNotBeDifferentFromInput() {
        address.setNumber(1);
        assertThat(address.getNumber()).isEqualTo(1);
    }

    @Test
    void numberShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> address.setNumber(null))
                .hasMessageContaining("Address number should not be null");
    }

    @Test
    void numberShouldThrowExceptionIfUnderZero() {
        assertThatThrownBy(() -> address.setNumber(-1))
                .hasMessageContaining("Address number needs to be over 0");
    }

}