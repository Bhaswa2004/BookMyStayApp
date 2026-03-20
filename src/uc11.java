import java.util.*;

class SharedInventory {

    private int rooms = 2;

    public synchronized boolean allocateRoom(String guest){

        if(rooms > 0){

            System.out.println(guest + " allocated room.");

            rooms--;

            return true;
        }

        System.out.println(guest + " failed (no rooms left)");

        return false;
    }
}

class BookingThread extends Thread {

    SharedInventory inventory;
    String guest;

    public BookingThread(SharedInventory inventory,String guest){

        this.inventory = inventory;
        this.guest = guest;
    }

    public void run(){

        inventory.allocateRoom(guest);
    }
}

public class uc11 {

    public static void main(String[] args){

        System.out.println("Book My Stay App - Version 11.0\n");

        SharedInventory inventory = new SharedInventory();

        Thread t1 = new BookingThread(inventory,"Alice");
        Thread t2 = new BookingThread(inventory,"Bob");
        Thread t3 = new BookingThread(inventory,"Charlie");

        t1.start();
        t2.start();
        t3.start();
    }
}
