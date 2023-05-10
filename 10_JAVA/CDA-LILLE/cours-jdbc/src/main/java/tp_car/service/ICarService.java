package tp_car.service;

import tp_car.entity.Car;

import java.util.List;

public class ICarService {
    Car save(Car car);
    List<Car> findAll();
}
