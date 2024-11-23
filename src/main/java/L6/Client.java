package L6;

import java.util.Objects;
import lombok.NonNull;

public class Client implements Comparable<Client> {
    private @NonNull String name;
    private @NonNull String surname;
    private @NonNull String phoneNumber;

    public int compareTo(Client o) {
        return this.surname.compareTo(o.surname);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Client client = (Client)o;
            return this.name.equals(client.name) && this.surname.equals(client.surname) && this.phoneNumber.equals(client.phoneNumber);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name, this.surname, this.phoneNumber});
    }

    public Client() {
    }

    public @NonNull String getName() {
        return this.name;
    }

    public @NonNull String getSurname() {
        return this.surname;
    }

    public @NonNull String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Client setName(@NonNull String name) {
        if (name == null) {
            throw new NullPointerException("name is marked non-null but is null");
        } else {
            this.name = name;
            return this;
        }
    }

    public Client setSurname(@NonNull String surname) {
        if (surname == null) {
            throw new NullPointerException("surname is marked non-null but is null");
        } else {
            this.surname = surname;
            return this;
        }
    }

    public Client setPhoneNumber(@NonNull String phoneNumber) {
        if (phoneNumber == null) {
            throw new NullPointerException("phoneNumber is marked non-null but is null");
        } else {
            this.phoneNumber = phoneNumber;
            return this;
        }
    }

    public String toString() {
        String var10000 = this.getName();
        return "Client(name=" + var10000 + ", surname=" + this.getSurname() + ", phoneNumber=" + this.getPhoneNumber() + ")";
    }
}