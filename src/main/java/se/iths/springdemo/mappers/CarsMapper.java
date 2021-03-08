package se.iths.springdemo.mappers;

import org.springframework.stereotype.Component;
import se.iths.springdemo.dtos.CarsDto;
import se.iths.springdemo.entities.Cars;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CarsMapper {
    public CarsMapper() {
    }

    public CarsDto mapp(Cars cars) {
        return new CarsDto(cars.getId(), cars.getBrand(), cars.getModel());
    }

    public Cars mapp(CarsDto carsDto) {
        return new Cars(carsDto.getId(), carsDto.getBrand(), carsDto.getModel());
    }

    public Optional<CarsDto> mapp(Optional<Cars> optionalPerson) {
        if (optionalPerson.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalPerson.get()));
    }

    public List<CarsDto> mapp(List<Cars> all) {

        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());

//        List<PersonDto> personDtoList = new ArrayList<>();
//        for (var person: all ) {
//            personDtoList.add(mapp(person));
//        }
//        return personDtoList;
    }
}