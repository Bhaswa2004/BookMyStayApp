import java.util.*;

class Reservation {

    String id;
    String guest;
    String roomType;

    public Reservation(String id, String guest, String roomType) {
        this.id = id;
        this.guest = guest;
        this.roomType = roomType;
    }

    public void display() {
        System.out.println(id + " | " + guest + " | " + roomType);
    }
}

class BookingHistory {

    private List<Reservation> history = new ArrayList<>();

    public void addReservation(Reservation r) {
        history.add(r);
    }

    public List<Reservation> getHistory() {
        return history;
    }
}

class BookingReportService {

    public void generateReport(List<Reservation> reservations) {

        System.out.println("Booking History Report\n");

        for (Reservation r : reservations) {
            r.display();
        }

        System.out.println("\nTotal Bookings: " + reservations.size());
    }
}

public class uc8 {

    public static void main(String[] args) {

        System.out.println("Book My Stay App - Version 8.0\n");

        BookingHistory history = new BookingHistory();

        history.addReservation(new Reservation("R101","Alice","Single Room"));
        history.addReservation(new Reservation("R102","Bob","Suite Room"));
        history.addReservation(new Reservation("R103","Charlie","Double Room"));

        BookingReportService report = new BookingReportService();

        report.generateReport(history.getHistory());
    }
}
