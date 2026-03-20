import java.util.HashMap;

class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {

        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    public void displayInventory() {

        System.out.println("Current Room Inventory:");

        for (String roomType : inventory.keySet()) {
            System.out.println(roomType + " -> " + inventory.get(roomType));
        }
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }
}

public class uc3 {

    public static void main(String[] args) {

        System.out.println("Book My Stay App - Version 3.0\n");

        RoomInventory inventory = new RoomInventory();

        inventory.displayInventory();

        System.out.println("\nChecking availability for Single Room:");
        System.out.println(inventory.getAvailability("Single Room"));

        System.out.println("\nUpdating availability for Suite Room...");

        inventory.updateAvailability("Suite Room", 1);

        inventory.displayInventory();
    }
}