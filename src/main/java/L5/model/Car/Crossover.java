package L5.model.Car;
import L5.model.Client.Client;

public class Crossover extends Car {
    public Crossover() {
        super(CarType.Crossover);
    }

    @Override
    public void clearCar() {
        getClients().clear();
    }

    @Override
    public void removeClientFromCar(Client client) {
        getClients().removeIf(c -> c.equals(client));
    }

    @Override
    public void addClientToCar(Client client) {
        getClients().add(client);
    }
}