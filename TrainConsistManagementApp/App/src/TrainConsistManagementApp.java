import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainValidationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Regex Patterns as per requirements
        String trainIdRegex = "TRN-\\d{4}";        // TRN- followed by exactly 4 digits
        String cargoCodeRegex = "PET-[A-Z]{2}";    // PET- followed by exactly 2 uppercase letters

        System.out.println("==========================================");
        System.out.println("UC11 - Validate Train ID and Cargo Code");
        System.out.println("==========================================");

        // Input gathering
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainIdInput = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCodeInput = scanner.nextLine();

        // Validation Logic
        boolean isTrainIdValid = Pattern.matches(trainIdRegex, trainIdInput);
        boolean isCargoCodeValid = Pattern.matches(cargoCodeRegex, cargoCodeInput);

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainIdValid);
        System.out.println("Cargo Code Valid: " + isCargoCodeValid);

        System.out.println("\nUC11 validation completed...");
        scanner.close();
    }
}