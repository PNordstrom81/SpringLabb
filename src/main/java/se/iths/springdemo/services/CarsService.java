package se.iths.springdemo.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se.iths.springdemo.dtos.CarsDto;
import se.iths.springdemo.dtos.CarsModel;
import se.iths.springdemo.entities.Cars;
import se.iths.springdemo.mappers.CarsMapper;
import se.iths.springdemo.repositories.CarsRepsitory;

import java.util.List;
import java.util.Optional;

@Service
public class CarsService implements se.iths.springdemo.services.Service {

    private final CarsMapper carsMapper;
    private CarsRepsitory carsRepsitory;

    public CarsService(CarsRepsitory carsRepsitory, CarsMapper carsMapper) {
        this.carsRepsitory = carsRepsitory;
        this.carsMapper = carsMapper;
    }

    @Override
    public List<CarsDto> getAllCars() {
        return carsMapper.mapp(carsRepsitory.findAll());
    }

    @Override
    public Optional<CarsDto> getOne(Integer id) {
        return carsMapper.mapp(carsRepsitory.findById(id));
    }

    @Override
    public CarsDto createCar(CarsDto cars) {
        if (cars.getBrand().isEmpty())
            throw new RuntimeException();

        //Mapp from CarsDto to Cars
        return carsMapper.mapp(carsRepsitory.save(carsMapper.mapp(cars)));
    }

    @Override
    public void deleteCar(Integer id) {
        carsRepsitory.deleteById(id);
    }

    @Override
    public CarsDto replaceCar(Integer id, CarsDto carsDto) {
        Optional<Cars> cars = carsRepsitory.findById(id);
        if( cars.isPresent())
        {
            Cars updatedCars = cars.get();
            updatedCars.setBrand(carsDto.getBrand());
            updatedCars.setModel(carsDto.getModel());
            return carsMapper.mapp(carsRepsitory.save(updatedCars));
        }
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Id " + id + " not found.");
    }

    @Override
    public CarsDto updateCar(Integer id, CarsModel carsModel) {
        Optional<Cars> cars = carsRepsitory.findById(id);
        if( cars.isPresent())
        {
            Cars updatedCars = cars.get();
            if( carsModel.model != null)
                updatedCars.setModel(carsModel.model);
            return carsMapper.mapp(carsRepsitory.save(updatedCars));
        }
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Id " + id + " not found.");
    }

    @Override
    public List<CarsDto> searchByBrand(String brand) {
        return carsMapper.mapp(carsRepsitory.findAllByBrand(brand));
    }
}