package L5.service;

import L5.exception.CarIsBuyedException;
import org.junit.jupiter.api.Test;

import L5.model.Car.Car;
import L5.model.Car.CarType;
import L5.model.Car.Compartment;
import L5.model.Client.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CarBuyManagerTest {
    private CarBuyManager carBuyManager;
    private Car compartment;
    private Client clientCompartment;

    @BeforeEach
    void setUp() {
        carBuyManager = new CarBuyManager();
        compartment = new Compartment();
        clientCompartment = new Client("Петров Олег Иванович", CarType.Compartment, LocalDate.of(2024, 7, 8), LocalDate.of(2024, 8, 10));
    }

    @AfterEach
    void tearDown() {
        compartment.clearCar();
    }

    @Test
    void addClientToCar_success() {
        assertDoesNotThrow(() -> carBuyManager.addClientToCar(compartment, clientCompartment), "Должно быть возможно предложить клиенту нужный тип автомобиля.");
        assertTrue(carBuyManager.cars.containsKey(CarType.Compartment), "Автомобиль должен быть добавлен в наличии.");
        assertEquals(1, compartment.getClients().size(), "Клиент должен быть добавлен к автомобилю.");
    }

    @Test
    void addClientToCar_carIsRented() {
        assertDoesNotThrow(() -> carBuyManager.addClientToCar(compartment, clientCompartment)); // Занимаем машину клиентом SUV
        Client clientCrossover = new Client("Иванов Иван Иванович", CarType.Compartment, LocalDate.of(1990, 5, 15), LocalDate.of(2024, 11, 15)); // Создаем нового клиента для SUV
        assertThrows(CarIsBuyedException.class, () -> carBuyManager.addClientToCar(compartment, clientCrossover), "Ожидается исключение CarIsBuyedException");
    }
}