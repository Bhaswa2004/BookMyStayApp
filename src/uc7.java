import java.util.*;

class Service {

    String name;
    double price;

    public Service(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class AddOnServiceManager {

    private Map<String, List<Service>> reservationServices = new HashMap<>();

    public void addService(String reservationId, Service service) {

        reservationServices
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    public void displayServices(String reservationId) {

        List<Service> services = reservationServices.get(reservationId);

        double total = 0;

        if (services != null) {

            System.out.println("Services for reservation " + reservationId);

            for (Service s : services) {
                System.out.println(s.name + " $" + s.price);
                total += s.price;
            }

            System.out.println("Total Add-On Cost: $" + total);
        }
    }
}

public class uc7 {

    public static void main(String[] args) {

        System.out.println("Book My Stay App - Version 7.0\n");

        AddOnServiceManager manager = new AddOnServiceManager();

        manager.addService("R101", new Service("Breakfast", 20));
        manager.addService("R101", new Service("Airport Pickup", 35));
        manager.addService("R101", new Service("Spa Access", 50));

        manager.displayServices("R101");
    }
}
