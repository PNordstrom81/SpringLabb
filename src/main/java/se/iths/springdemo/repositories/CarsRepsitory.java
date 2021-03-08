package se.iths.springdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.iths.springdemo.entities.Cars;

import java.util.List;

@Repository
public interface CarsRepsitory extends JpaRepository<Cars, Integer> {
    List<Cars> findAllByModel(String model);
    List<Cars> findAllByBrand(String brand);
}
