// Instructions

// Create a file MapInventory.java.

// Write two functions:

// Write a function getProductPrice that takes in parameters a map of product IDs and their corresponding prices, along with a product ID, and returns the price of the specified product. If the product ID is not present in the map, the function should return -1.

// Write a function getProductIdsByPrice that takes a map of product IDs and their corresponding prices, along with a price as parameter, and returns a list of product IDs that have the given price. If no products are found for the specified price, the function should return an empty list.

// Expected Functions
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;

// public class MapInventory {
//     public static int getProductPrice(Map<String, Integer> inventory, String productId) {
//         // your code here
//     }

//     public static List<String> getProductIdsByPrice(Map<String, Integer> inventory, int price) {
//         // your code here
//     }
// }
// Usage
// Here is a possible ExerciseRunner.java to test your functions:

// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// public class ExerciseRunner {

//     public static void main(String[] args) {
//         Map<String, Integer> inventory = new HashMap<>();
//         inventory.put("P001", 100);
//         inventory.put("P002", 50);
//         inventory.put("P003", 75);
//         inventory.put("P004", 50);
//         inventory.put("P005", 75);

//         System.out.println(MapInventory.getProductPrice(inventory, "P002")); // Output: 50
//         System.out.println(MapInventory.getProductPrice(inventory, "P004")); // Output: 50
//         System.out.println(MapInventory.getProductPrice(inventory, "P006")); // Output: -1

//         List<String> productsWithPrice50 = MapInventory.getProductIdsByPrice(inventory, 50);
//         System.out.println(productsWithPrice50); // Output: [P002, P004]

//         List<String> productsWithPrice75 = MapInventory.getProductIdsByPrice(inventory, 75);
//         System.out.println(productsWithPrice75); // Output: [P003, P005]

//         List<String> productsWithPrice80 = MapInventory.getProductIdsByPrice(inventory, 80);
//         System.out.println(productsWithPrice80); // Output: []
//     }
// }
// and its output :

// $ javac *.java -d build
// $ java -cp build ExerciseRunner
// 50
// 50
// -1
// [P002, P004]
// [P003, P005]
// []
// $

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapInventory {
    public static int getProductPrice(Map<String, Integer> inventory, String productId) {
        return inventory.getOrDefault(productId, -1);
    }

    public static List<String> getProductIdsByPrice(Map<String, Integer> inventory, int price) {
        List<String> productIds = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            if (entry.getValue() == price) {
                productIds.add(entry.getKey());
            }
        }
        return productIds;
    }
}
