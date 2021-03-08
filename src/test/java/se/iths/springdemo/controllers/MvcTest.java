package se.iths.springdemo.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import se.iths.springdemo.dtos.CarsDto;
import se.iths.springdemo.services.Service;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@WebMvcTest(CarsController.class)
@Import(TestConfiguration.class)
//@Import(TestService.class)
public class MvcTest {

    @MockBean
    Service service;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper jsonMapper;

    @Test
    void callingWithUrlCarsShouldReturnAllPersonsAsJson() throws Exception {
        //Tell mockito what to return when callingfmethods on Service
        when(service.getAllCars()).thenReturn(List.of(new CarsDto(1,"Volvo","740")));

        var result = mockMvc.perform(MockMvcRequestBuilders.get("/cars")
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    void callingPOSTWithNewCarShouldSaveCarToServiceAndReturnNewCarWithId() throws Exception {
        //Tell mockito what to return when callingfmethods on Service
        var carsDto = new CarsDto(0,"Saab","95");

        when(service.createCar(eq(carsDto))).thenReturn(new CarsDto(1,"Volvo","740"));

        var result = mockMvc.perform(MockMvcRequestBuilders.post("/cars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMapper.writeValueAsBytes(carsDto))
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(201);
    }
}
