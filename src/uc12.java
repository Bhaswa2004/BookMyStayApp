import java.io.*;
import java.util.*;

public class uc12 {

    public static void main(String[] args) {

        System.out.println("Book My Stay App - Version 12.0\n");

        Map<String,Integer> inventory = new HashMap<>();

        inventory.put("Single",3);
        inventory.put("Suite",1);

        String file = "inventory.dat";

        try{

            ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream(file));

            out.writeObject(inventory);

            out.close();

            System.out.println("Inventory saved.");

        }catch(Exception e){

            System.out.println("Save error");
        }

        try{

            ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream(file));

            Map<String,Integer> restored =
                    (Map<String,Integer>) in.readObject();

            in.close();

            System.out.println("Recovered Inventory: " + restored);

        }catch(Exception e){

            System.out.println("Recovery error");
        }
    }
}
