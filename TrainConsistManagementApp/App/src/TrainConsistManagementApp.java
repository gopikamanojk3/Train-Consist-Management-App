import java.util.Arrays;
import java.util.List;

class Bogie {
    String type;
    int capacity;

    Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("UC10 - Count Total Seats in Train");
        System.out.println("==========================================");

        // 1. Create a list of bogies
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70)
        );

        System.out.println("Bogies in Train:");
        bogies.forEach(b -> System.out.println(b.type + " -> " + b.capacity));

        // 2. Stream Pipeline: map() to extract capacity, reduce() to sum
        int totalCapacity = bogies.stream()
                .map(Bogie::getCapacity) // Extract numeric values
                .reduce(0, Integer::sum); // Aggregate into total

        System.out.println("\nTotal Seating Capacity of Train: " + totalCapacity);
        System.out.println("\nUC10 aggregation completed...");
    }
}