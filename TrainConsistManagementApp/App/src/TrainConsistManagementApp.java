import java.util.LinkedHashSet;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // Creating LinkedHashSet for train formation
        LinkedHashSet<String> trainFormation = new LinkedHashSet<>();

        // Adding bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Attempting to add duplicate bogie
        trainFormation.add("Sleeper");

        System.out.println("==================================");
        System.out.println("UC5 - Preserve Insertion Order of Bogies");
        System.out.println("==================================\n");

        // Display final train formation
        System.out.println("Final Train Formation:");
        System.out.println(trainFormation);

        System.out.println("\nNote:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");

        System.out.println("\nUC5 formation setup completed...");
    }
}