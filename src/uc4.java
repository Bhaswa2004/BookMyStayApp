import java.util.HashMap;

class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 0);
        inventory.put("Suite Room", 2);
    }

    public HashMap<String, Integer> getInventory() {
        return inventory;
    }
}

class Room {

    String type;
    double price;

    public Room(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println(type + " | Price: $" + price);
    }
}

public class uc4 {

    public static void main(String[] args) {

        System.out.println("Book My Stay App - Version 4.0\n");

        RoomInventory inventory = new RoomInventory();

        HashMap<String, Integer> rooms = inventory.getInventory();

        HashMap<String, Room> roomDetails = new HashMap<>();

        roomDetails.put("Single Room", new Room("Single Room", 100));
        roomDetails.put("Double Room", new Room("Double Room", 180));
        roomDetails.put("Suite Room", new Room("Suite Room", 350));

        System.out.println("Available Rooms:\n");

        for (String roomType : rooms.keySet()) {

            int available = rooms.get(roomType);

            if (available > 0) {

                roomDetails.get(roomType).displayDetails();
                System.out.println("Available: " + available + "\n");

            }
        }
    }
}
