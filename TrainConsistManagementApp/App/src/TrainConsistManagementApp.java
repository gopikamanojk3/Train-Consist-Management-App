import java.util.Arrays;
import java.util.List;

class GoodsBogie {
    String type;
    String cargo;

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("==========================================");

        // 1. Prepare list of goods bogies
        List<GoodsBogie> goodsBogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain"),
                new GoodsBogie("Cylindrical", "Coal") // This violates the rule
        );

        System.out.println("Goods Bogies in Train:");
        goodsBogies.forEach(b -> System.out.println(b.type + " -> " + b.cargo));

        // 2. Stream with allMatch() to enforce safety rules
        // Rule: If type is Cylindrical, cargo must be Petroleum.
        // Logic: !(type is Cylindrical) OR (cargo is Petroleum)
        boolean isSafe = goodsBogies.stream().allMatch(b -> {
            if (b.type.equals("Cylindrical")) {
                return b.cargo.equals("Petroleum");
            }
            return true; // Non-cylindrical bogies pass by default here
        });

        System.out.println("\nSafety Compliance Status: " + isSafe);
        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
    }
}