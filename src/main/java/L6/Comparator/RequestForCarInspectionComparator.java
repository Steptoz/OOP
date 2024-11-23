package L6.Comparator;

import L6.RequestForCarInspection;

import java.util.Comparator;

public class RequestForCarInspectionComparator implements Comparator<RequestForCarInspection> {
    public RequestForCarInspectionComparator() {
    }

    public int compare(RequestForCarInspection r1, RequestForCarInspection r2) {
        return r1.getTitle().compareTo(r2.getTitle());
    }
}
