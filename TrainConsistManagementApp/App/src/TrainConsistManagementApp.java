import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println(" UC3 - Track Unique Bogie IDs ");
        System.out.println("====================================\n");

        // Create HashSet for bogie IDs (ensures uniqueness)
        Set<String> bogieIds = new HashSet<>();

        // Add bogie IDs (including duplicates intentionally)
        bogieIds.add("BG104");
        bogieIds.add("BG103");
        bogieIds.add("BG102");
        bogieIds.add("BG101");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        // Display final set
        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogieIds);

        // Note about duplicates
        System.out.println("\nNote:");
        System.out.println("Duplicates are automatically ignored by HashSet.");

        System.out.println("\nUC3 uniqueness validation completed...");
    }
}