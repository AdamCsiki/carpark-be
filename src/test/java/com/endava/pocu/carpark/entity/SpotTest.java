package com.endava.pocu.carpark.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class SpotTest {
    private Spot spot;

    @BeforeEach
    void init() {
        spot = new Spot();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0",
            "1",
            "9999999999"
    })
    public void priceShouldNotBeDifferentFromInput(Double price) {
        spot.setPrice(price);
        assertThat(spot.getPrice()).isEqualTo(price);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-999.0",
            "-1.0"
    })
    public void priceShouldThrowExceptionIfUnderZero(Double price) {
        assertThatThrownBy(() -> spot.setPrice(price))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Spot price should be higher or equal to 0");
    }

    @Test
    public void priceShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> spot.setPrice(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Spot price should not be null");
    }

    @Test
    public void usedShouldNotBeDifferentFromInput() {
        spot.setUsed(true);
        assertThat(spot.getUsed()).isTrue();
    }

    @Test
    public void usedShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> spot.setUsed(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Spot isUsed should not be null");
    }

    @Test
    public void dateStartShouldNotBeDifferentFromInput() {
        LocalDateTime dateNow = LocalDateTime.now();
        spot.setDateStart(dateNow);
        assertThat(spot.getDateStart()).isEqualTo(dateNow);
    }

    @Test
    public void dateStartShouldThrowExceptionIfAfterDateEnd() {
        LocalDateTime dateNow = LocalDateTime.now();
        LocalDateTime dateBefore = LocalDateTime.now().minusDays(1);

        spot.setDateEnd(dateBefore);
        assertThatThrownBy(() -> spot.setDateStart(dateNow))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Spot dateStart");
    }
}