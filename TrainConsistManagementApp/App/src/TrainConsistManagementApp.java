import java.util.*;
import java.util.stream.Collectors;

class TrainConsistManagementApp {
    private String type;
    private int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Capacity -> " + capacity;
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // Step 1: Create list of bogies
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );

        System.out.println("=========================================================");
        System.out.println("UC9 - Group Bogies by Type");
        System.out.println("=========================================================");

        // Step 2: Group bogies using Collectors.groupingBy
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        // Step 3: Display grouped result
        groupedBogies.forEach((type, bogieList) -> {
            System.out.println("\nBogie Type: " + type);
            bogieList.forEach(System.out::println);
        });

        System.out.println("\nUC9 grouping completed...");
    }
}
