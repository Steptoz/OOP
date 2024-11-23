package L5.service;

import L5.exception.CarIsBuyedException;
import L5.exception.WrongCarTypeException;
import L5.model.Car.Car;
import L5.model.Car.CarType;
import L5.model.Client.Client;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

// Объявляем логгер
@Slf4j
public class CarBuyManager {
    final Map<CarType, Car> cars = new HashMap<>();

    public void addClientToCar(Car car, Client client) throws WrongCarTypeException {
        try {
            checkCarAvailabilityAndType(car, client);
            car.addClientToCar(client);
            cars.put(car.getCarType(), car);
            log.info("Клиенту присвоен нужный тип автомобиля: {}", car.getCarType());
        } catch (CarIsBuyedException | WrongCarTypeException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            logBuyStatus(car);
        }
    }

    private void logBuyStatus(Car car) {
        if (cars.containsKey(car.getCarType())) {
            log.info("Автомобиль {} в наличии.", car.getCarType());
        } else {
            log.warn("Автомобиль {} не в наличии.", car.getCarType());
        }
    }

    private void checkCarAvailabilityAndType(Car car, Client client) throws CarIsBuyedException, WrongCarTypeException {
        // Проверяем тип автомобиля
        if (car.getCarType() != client.getPreferredCarType()) {
            throw new WrongCarTypeException("Клиент запросил другой тип автомобиля: " + client.getPreferredCarType());
        }
        // Проверяем доступность автомобиля
        if (!car.getClients().isEmpty()) { // Проверяем на занятость
            throw new CarIsBuyedException("Запрашиваемый тип автомобиля в данный момент не в наличии.");
        }
    }
}