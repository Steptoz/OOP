package L5.model.Client;

import L5.model.Car.CarType;

import java.time.LocalDate;
import java.util.Objects;


public class Client {
    private String FIO;
    private CarType preferredCarType;
    private LocalDate birthDate;
    private LocalDate DateOfSale;

    public Client(String fio, CarType preferredCarType, LocalDate birthDate, LocalDate rentalDate) {
        this.FIO = fio;
        this.preferredCarType = preferredCarType;
        this.birthDate = birthDate;
        this.DateOfSale = rentalDate;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public CarType getPreferredCarType() { // Добавили геттер
        return preferredCarType;
    }

    public void setPreferredCarType(CarType preferredCarType) {
        this.preferredCarType = preferredCarType;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDateOfSale() {
        return DateOfSale;
    }

    public void setDateOfSale(LocalDate dateOfSale) {
        this.DateOfSale = dateOfSale;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client other = (Client) obj;
        return Objects.equals(FIO, other.FIO) &&
                preferredCarType == other.preferredCarType &&
                birthDate.equals(other.birthDate) &&
                DateOfSale.equals(other.DateOfSale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FIO, preferredCarType, birthDate, DateOfSale);
    }
}