import java.util.*;

class Inventory {

    Map<String,Integer> rooms = new HashMap<>();

    public Inventory() {
        rooms.put("Single",2);
        rooms.put("Suite",1);
    }

    public void increase(String type){
        rooms.put(type, rooms.get(type)+1);
    }

    public void decrease(String type){
        rooms.put(type, rooms.get(type)-1);
    }

    public void display(){
        System.out.println("Inventory: " + rooms);
    }
}

public class uc10 {

    public static void main(String[] args) {

        System.out.println("Book My Stay App - Version 10.0\n");

        Inventory inventory = new Inventory();

        Stack<String> rollbackStack = new Stack<>();

        Map<String,String> bookings = new HashMap<>();

        bookings.put("R101","Single");
        bookings.put("R102","Suite");

        rollbackStack.push("RM101");
        rollbackStack.push("RM102");

        inventory.display();

        System.out.println("\nCancelling reservation R102");

        if(bookings.containsKey("R102")){

            String type = bookings.remove("R102");

            inventory.increase(type);

            String releasedRoom = rollbackStack.pop();

            System.out.println("Released Room ID: " + releasedRoom);
        }

        inventory.display();
    }
}
