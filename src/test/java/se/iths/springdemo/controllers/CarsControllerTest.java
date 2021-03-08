package se.iths.springdemo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsControllerTest {

    //Unit tests. Testing one thing at a time, in isolation.
    @Test
    void listAllCarsInDatabase() {
    }
    @Test
    void callingOneWithValidIdReturnsOneCar(){
        CarsController carsController = new CarsController(new TestService());

        var cars = carsController.getOne(1);

        //AssertJ fluent assertions
        assertThat(cars.getId()).isEqualTo(1);
        assertThat(cars.getBrand()).isEqualTo("Volvo");
        assertThat(cars.getModel()).isEqualTo("740");
    }

    @Test
    void callingOneWithInvalidIdThrowsExceptionWithResponseStatus404(){
        CarsController carsController = new CarsController(new TestService());

        var exception = assertThrows(ResponseStatusException.class, () -> carsController.getOne(5) );
        assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
    }



    @Test
    void createACar() {
    }
        @Test
        void deleteACarWithSpecificId() {
        }

        @Test
        void replaceASpecificCarById() {
        }

        @Test
        void updateACar() {
        }
    }