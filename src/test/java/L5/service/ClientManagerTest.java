package L5.service;

import org.junit.jupiter.api.DisplayName;
import L5.exception.InvalidDateException;
import L5.model.Car.CarType;
import L5.model.Client.Client;
import org.junit.jupiter.api.*;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ClientManagerTest {
    private static final Client client = new Client("Петров Олег Иванович", CarType.Compartment, LocalDate.of(2024, 7, 8), null);
    private static final String VALID_DATE = "2024-8-10";
    private static final String INVALID_DATE_FORMAT = "2024/8/10";
    private static final String PAST_DATE = "2024-02-03";
    private final ClientManager clientManager = new ClientManager();

    @Test
    @DisplayName("Позитивный тест: проверка установки правильной даты продажи")
    void testSetValidRentalDate() throws InvalidDateException {
        clientManager.setBuyDate(client, VALID_DATE);
        assertEquals(LocalDate.parse(VALID_DATE), client.getDateOfSale(), "Дата продажи не соответствует ожидаемой.");
    }

    @Test
    @DisplayName("Негативный тест: проверка установки даты продажи в неправильном формате.\n" +
            "Ожидается исключение InvalidDateException")
    void testInvalidDateFormat() {
        assertThrows(InvalidDateException.class,
                () -> clientManager.setBuyDate(client, INVALID_DATE_FORMAT),
                "Ожидалось исключение InvalidDateException из-за неверного формата даты.");
    }

    @Test
    @DisplayName("Негативный тест: проверка установки даты продажи в прошлом.\n" +
            "Ожидается исключение InvalidDateException.")
    void testPastDate() {
        assertThrows(InvalidDateException.class,
                () -> clientManager.setBuyDate(client, PAST_DATE),
                "Ожидалось исключение InvalidDateException из-за попытки установки прошедшей даты.");
    }
}