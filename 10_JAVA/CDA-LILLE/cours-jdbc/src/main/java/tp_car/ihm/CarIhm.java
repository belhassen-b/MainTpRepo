package tp_car.ihm;

import fr.benseddik.domain.Car;
import fr.benseddik.service.impl.CarServiceImpl;

public class CarIhm {
    public static void main(String[] args) {

        final CarServiceImpl carService = new CarServiceImpl();
Car car = Car.builder()
        .model("test")
        .year("2020")
        .price(15.20)
        .power(15)
        .build();
        car = carService.save(car);
        System.out.println(car);

    }
}
