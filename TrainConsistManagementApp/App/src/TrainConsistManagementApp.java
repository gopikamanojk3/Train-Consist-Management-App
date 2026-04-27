import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// UC14: Custom Exception for Domain Validation
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Base Bogie Class
class Bogie {
    String type;
    int capacity;
    String cargo;

    // UC14: Constructor with Fail-Fast Validation
    Bogie(String type, int capacity, String cargo) throws InvalidCapacityException {
        if (capacity < 0) { // Specific check for UC14 logic
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
        this.cargo = cargo;
    }

    public int getCapacity() { return capacity; }
    public String getType() { return type; }
    public String getCargo() { return cargo; }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        try {
            // --- DATA SETUP ---
            List<Bogie> trainConsist = new ArrayList<>();
            trainConsist.add(new Bogie("Sleeper", 72, "Passengers"));
            trainConsist.add(new Bogie("AC Chair", 56, "Passengers"));
            trainConsist.add(new Bogie("First Class", 24, "Passengers"));
            trainConsist.add(new Bogie("Sleeper", 70, "Passengers"));
            trainConsist.add(new Bogie("Cylindrical", 0, "Petroleum"));
            trainConsist.add(new Bogie("Open", 0, "Coal"));

            // --- UC10: Count Total Seats (reduce) ---
            System.out.println("==========================================");
            System.out.println("UC10 - Count Total Seats in Train");
            System.out.println("==========================================");
            int totalSeats = trainConsist.stream()
                    .map(Bogie::getCapacity)
                    .reduce(0, Integer::sum);
            System.out.println("Total Seating Capacity: " + totalSeats);

            // --- UC11: Validate Train ID & Cargo (Regex) ---
            System.out.println("\n==========================================");
            System.out.println("UC11 - Validate Train ID & Cargo Codes");
            System.out.println("==========================================");
            String trainID = "TRN-6524";
            String cargoCode = "PET-FH";
            boolean isTrainValid = Pattern.matches("TRN-\\d{4}", trainID);
            boolean isCargoValid = Pattern.matches("PET-[A-Z]{2}", cargoCode);
            System.out.println("Train ID [" + trainID + "] Valid: " + isTrainValid);
            System.out.println("Cargo Code [" + cargoCode + "] Valid: " + isCargoValid);

            // --- UC12: Safety Compliance (allMatch) ---
            System.out.println("\n==========================================");
            System.out.println("UC12 - Safety Compliance Check");
            System.out.println("==========================================");
            // Add a violation for demonstration
            trainConsist.add(new Bogie("Cylindrical", 0, "Coal"));

            boolean isSafe = trainConsist.stream().allMatch(b ->
                    !b.getType().equals("Cylindrical") || b.getCargo().equals("Petroleum"));

            System.out.println("Safety Compliance Status: " + isSafe);
            System.out.println(isSafe ? "Train formation is SAFE." : "Train formation is NOT SAFE.");

            // --- UC13: Performance Comparison ---
            System.out.println("\n==========================================");
            System.out.println("UC13 - Performance (Loops vs Streams)");
            System.out.println("==========================================");
            long startLoop = System.nanoTime();
            List<Bogie> loopFiltered = new ArrayList<>();
            for(Bogie b : trainConsist) if(b.capacity > 60) loopFiltered.add(b);
            long endLoop = System.nanoTime();

            long startStream = System.nanoTime();
            List<Bogie> streamFiltered = trainConsist.stream()
                    .filter(b -> b.capacity > 60).collect(Collectors.toList());
            long endStream = System.nanoTime();

            System.out.println("Loop Time (ns): " + (endLoop - startLoop));
            System.out.println("Stream Time (ns): " + (endStream - startStream));

            // --- UC14: Exception Handling (Fail-Fast) ---
            System.out.println("\n==========================================");
            System.out.println("UC14 - Handle Invalid Bogie Capacity");
            System.out.println("==========================================");
            System.out.println("Attempting to create bogie with capacity -10...");
            new Bogie("Sleeper", -10, "Passengers");

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("UC14 exception handling completed...");
        }
    }
}