import java.util.LinkedList;
import java.util.Queue;

class Reservation {

    String guestName;
    String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public void display() {
        System.out.println(guestName + " requested " + roomType);
    }
}

public class uc5 {

    public static void main(String[] args) {

        System.out.println("Book My Stay App - Version 5.0\n");

        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Alice", "Single Room"));
        bookingQueue.add(new Reservation("Bob", "Suite Room"));
        bookingQueue.add(new Reservation("Charlie", "Double Room"));

        System.out.println("Booking Requests in Queue:\n");

        for (Reservation r : bookingQueue) {
            r.display();
        }
    }
}
