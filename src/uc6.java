import java.util.*;

class RoomInventory {

    HashMap<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single Room", 2);
        inventory.put("Suite Room", 1);
    }

    public boolean isAvailable(String type) {
        return inventory.getOrDefault(type, 0) > 0;
    }

    public void allocate(String type) {
        inventory.put(type, inventory.get(type) - 1);
    }
}

public class uc6 {

    public static void main(String[] args) {

        System.out.println("Book My Stay App - Version 6.0\n");

        Queue<String> bookingQueue = new LinkedList<>();

        bookingQueue.add("Single Room");
        bookingQueue.add("Suite Room");

        Set<String> allocatedRooms = new HashSet<>();

        RoomInventory inventory = new RoomInventory();

        int roomIdCounter = 101;

        while (!bookingQueue.isEmpty()) {

            String request = bookingQueue.poll();

            if (inventory.isAvailable(request)) {

                String roomId = request.substring(0,2).toUpperCase() + roomIdCounter++;

                allocatedRooms.add(roomId);

                inventory.allocate(request);

                System.out.println("Reservation Confirmed → Room ID: " + roomId);

            } else {

                System.out.println("No rooms available for " + request);
            }
        }
    }
}
