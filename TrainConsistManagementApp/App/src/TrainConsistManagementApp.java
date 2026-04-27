import java.util.ArrayList;
import java.util.List;

public class TrainConsistUC1 {
    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("  Train Consist Management App");
        System.out.println("====================================\n");

        // Initialize empty train consist using ArrayList
        List<String> trainConsist = new ArrayList<>();

        // Display initialization message
        System.out.println("Train initialized successfully...");

        // Display initial bogie count
        System.out.println("Initial Bogie Count : " + trainConsist.size());

        // Display current consist
        System.out.println("Current Train Consist : " + trainConsist);

        System.out.println("\nSystem ready for operations...");
    }
}