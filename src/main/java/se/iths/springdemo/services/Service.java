package se.iths.springdemo.services;

import se.iths.springdemo.dtos.CarsDto;
import se.iths.springdemo.dtos.CarsModel;

import java.util.List;
import java.util.Optional;

public interface Service {
    List<CarsDto> getAllCars();

    Optional<CarsDto> getOne(Integer id);

    CarsDto createCar(CarsDto person);

    void deleteCar(Integer id);

    CarsDto replaceCar(Integer id, CarsDto carsDto);

    CarsDto updateCar(Integer id, CarsModel carsModel);

    List<CarsDto> searchByBrand(String brand);
}
