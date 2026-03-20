import java.util.*;

class InvalidBookingException extends Exception {

    public InvalidBookingException(String message) {
        super(message);
    }
}

class BookingValidator {

    private static Set<String> validRoomTypes =
            new HashSet<>(Arrays.asList("Single Room","Double Room","Suite Room"));

    public static void validate(String roomType, int available)
            throws InvalidBookingException {

        if (!validRoomTypes.contains(roomType)) {
            throw new InvalidBookingException("Invalid room type: " + roomType);
        }

        if (available <= 0) {
            throw new InvalidBookingException("No rooms available for " + roomType);
        }
    }
}

public class uc9 {

    public static void main(String[] args) {

        System.out.println("Book My Stay App - Version 9.0\n");

        String roomType = "Single Room";
        int availableRooms = 0;

        try {

            BookingValidator.validate(roomType, availableRooms);

            System.out.println("Booking is valid.");

        } catch (InvalidBookingException e) {

            System.out.println("Booking Error: " + e.getMessage());
        }
    }
}

