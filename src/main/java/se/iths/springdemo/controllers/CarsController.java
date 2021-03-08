package se.iths.springdemo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.iths.springdemo.dtos.CarsDto;
import se.iths.springdemo.dtos.CarsModel;
import se.iths.springdemo.services.Service;

import java.util.List;

//@RefreshScope
@RestController
public class CarsController {

    private final Service service;

    public CarsController(Service service) {
        this.service = service;
    }

    @GetMapping("/cars")
    public List<CarsDto> all() {
        return service.getAllCars();
    }

    @GetMapping("/cars/{id}")
    public CarsDto getOne(@PathVariable Integer id) {
        return service.getOne(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Id " + id + " not found."));
    }

    @PostMapping("/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public CarsDto create(@RequestBody CarsDto car) {
        return service.createCar(car);
    }


    @DeleteMapping("/cars/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteCar(id);
    }


    @PutMapping("/cars/{id}")
    public CarsDto replace(@RequestBody CarsDto carsDto, @PathVariable Integer id) {
        return service.replaceCar(id, carsDto);


}
    @PatchMapping("/cars/{id}")
    public CarsDto update(@RequestBody CarsModel carsModel, @PathVariable Integer id) {
        return service.updateCar(id, carsModel);
}
        @GetMapping(value = "/cars/search",params = "brand")
        public List<CarsDto> searchByBrand(@RequestParam String brand) {
            return service.searchByBrand(brand);

        }
}


