package se.iths.springdemo.controllers;

import se.iths.springdemo.dtos.CarsDto;
import se.iths.springdemo.dtos.CarsModel;
import se.iths.springdemo.services.Service;

import java.util.List;
import java.util.Optional;

public class TestService implements Service {
    @Override
    public List<CarsDto> getAllCars() {
        return List.of(new CarsDto(1,"Volvo","740), " +
                new CarsDto(2,"Porsche","GT")));
    }

    @Override
    public Optional<CarsDto> getOne(Integer id) {
        if( id == 1)
            return Optional.of(new CarsDto(1,"Volvo","740"));
        return Optional.empty();
    }

    @Override
    public CarsDto createCar(CarsDto car) {
        return null;
    }

    @Override
    public void deleteCar(Integer id) {

    }

    @Override
    public CarsDto replaceCar(Integer id, CarsDto carsDto) {
        return null;
    }

    @Override
    public CarsDto updateCar(Integer id, CarsModel carsModel) {
        return null;
    }



    @Override
    public List<CarsDto> searchByBrand(String brand) {
        return null;
    }
}
