package L6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import L6.Comparator.RequestForCarInspectionComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RequestForCarInspectionComparatorTest {
    private static Client client1 = (new Client()).setName("Иван").setSurname("Иванов").setPhoneNumber("73499636356");
    private static Client client2 = (new Client()).setName("Олег").setSurname("Петров").setPhoneNumber("79063462388");
    private static RequestForCarInspection request1;
    private static RequestForCarInspection request2;

    RequestForCarInspectionComparatorTest() {
    }

    @Test
    @DisplayName("Сортировка только по клиенту")
    void sortByClient() {
        List<RequestForCarInspection> requests = new ArrayList();
        requests.add(request2);
        requests.add(request1);
        requests.sort(Comparator.comparing(RequestForCarInspection::getClient));
        Assertions.assertEquals(requests.get(0), request1);
        Assertions.assertEquals(requests.get(1), request2);
    }

    @Test
    @DisplayName("Сортировка только по id")
    void sortById() {
        List<RequestForCarInspection> requests = new ArrayList();
        requests.add(request2);
        requests.add(request1);
        requests.sort(Comparator.comparing(RequestForCarInspection::getId));
        Assertions.assertEquals(requests.get(0), request1);
        Assertions.assertEquals(requests.get(1), request2);
    }

    @Test
    @DisplayName("Сортировка только по марке машины")
    void sortByTitle() {
        List<RequestForCarInspection> requests = new ArrayList();
        requests.add(request2);
        requests.add(request1);
        requests.sort(new RequestForCarInspectionComparator());
        Assertions.assertEquals(requests.get(0), request1);
        Assertions.assertEquals(requests.get(1), request2);
    }

    static {
        request1 = (new RequestForCarInspection()).setId(1).setTitle("Engine oil change").setClient(client1);
        request2 = (new RequestForCarInspection()).setId(2).setTitle("Сhecking tire pressure").setClient(client2);
    }
}